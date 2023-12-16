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
        val plan = performActionWithRetry { getWorkingPlan(firstDate) }

        outputView.showWorkingPlan(plan, HolidayDecider())
    }

    private fun getWorkingPlan(firstDate: Date): Map<Date, Worker> {
        val workerSequences = WorkerSequences(
            inputView.readWeekDaysWorkers().toWorkerSequence(),
            inputView.readHolidaysWorkers().toWorkerSequence()
        )

        return getOnCallWorkingPlan(firstDate, workerSequences)
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
        ).workers
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