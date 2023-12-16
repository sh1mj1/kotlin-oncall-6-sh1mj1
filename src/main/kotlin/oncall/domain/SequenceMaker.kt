package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.Worker
import oncall.domain.data.WorkerSequence

class SequenceMaker(private val holidayDecider: HolidayDecider) {

    fun makeSequence(date: Date, weekdayWorkers: WorkerSequence, holidayWorkers: WorkerSequence): List<Worker> {
        val totalWorkingSequence = mutableListOf<Worker>()
        val weekDayWork = weekdayWorkers.workers.toMutableList()
        val holidayWork = holidayWorkers.workers.toMutableList()

        var nowDate: Date = date.copy()
        repeat(date.lastDate()) {
            when (holidayDecider.isHoliday(nowDate)) {
                true -> {
                    val nextWorker = holidayWork.removeFirst()
                    totalWorkingSequence.add(nextWorker)
                    holidayWork.add(nextWorker)
                }

                false -> {
                    val nextWorker = weekDayWork.removeFirst()
                    totalWorkingSequence.add(nextWorker)
                    weekDayWork.add(nextWorker)
                }
            }
            nowDate = nowDate.nextDate()
        }
        return totalWorkingSequence.toList()
    }

}

