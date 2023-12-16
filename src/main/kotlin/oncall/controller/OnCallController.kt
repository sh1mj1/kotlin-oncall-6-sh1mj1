package oncall.controller

import oncall.domain.HolidayDecider
import oncall.domain.OnCallPlanner
import oncall.domain.data.Date
import oncall.domain.data.Worker
import oncall.domain.data.WorkerSequences
import oncall.view.InputView
import oncall.view.OutputView

class OnCallController(
    val inputView: InputView,
    val outputView: OutputView,
    val onCallPlanner: OnCallPlanner,
) {

    fun start() {
        val firstDate = performActionWithRetry { inputView.readMonthAndDay().toDate() }
        val workerSequences = getWorkerSequences()

        val plan = getOnCallWorkingPlan(firstDate, workerSequences)

        outputView.showWorkingPlan(plan, HolidayDecider())
    }

    private fun getWorkerSequences(): WorkerSequences {
        val workerSequences = performActionWithRetry {
            WorkerSequences(
                inputView.readWeekDaysWorkers().toWorkerSequence(),
                inputView.readHolidaysWorkers().toWorkerSequence()
            )
        }
        return workerSequences
    }

    private fun getOnCallWorkingPlan(
        firstDate: Date,
        workerSequences: WorkerSequences,
    ): Map<Date, Worker> = listsToMap(
        firstDate.getDatesInThisMonth(),
        onCallPlanner.makeTotalWorkingPlan(
            firstDate,
            workerSequences.weekdayWorkerSequences,
            workerSequences.holidayWorkerSequences
        )
    )

    private fun <T> performActionWithRetry(action: () -> T): T {
        do {
            try {
                return action()
            } catch (e: Exception) {
                outputView.showExceptionMessage(e)
            }
        } while (true)
    }
}