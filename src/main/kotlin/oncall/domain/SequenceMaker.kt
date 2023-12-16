package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.FinalWorkers
import oncall.domain.data.Worker
import oncall.domain.data.WorkerSequence

class SequenceMaker(private val holidayDecider: HolidayDecider) {

    fun makeSequence(date: Date, weekdayWorkers: WorkerSequence, holidayWorkers: WorkerSequence): FinalWorkers {
        val totalWorkingSequence = mutableListOf<Worker>()
        val weekDayWork = weekdayWorkers.workers.toMutableList()
        val holidayWork = holidayWorkers.workers.toMutableList()

        var nowDate: Date = date.copy()
        repeat(date.lastDate()) {
            val workers = if (holidayDecider.isHoliday(nowDate)) holidayWork else weekDayWork
            processWorker(workers, totalWorkingSequence)
            nowDate = nowDate.nextDate()
        }
        return FinalWorkers(totalWorkingSequence)
    }

    private fun processWorker(workers: MutableList<Worker>, totalWorkingSequence: MutableList<Worker>) {
        val nextWorker = workers.removeFirst()
        totalWorkingSequence.add(nextWorker)
        workers.add(nextWorker)
    }

}

