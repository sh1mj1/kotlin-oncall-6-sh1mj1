package oncall.view

import oncall.domain.HolidayDecider
import oncall.domain.data.Date
import oncall.domain.data.Worker

class OutputView {

    fun showExceptionMessage(e: Throwable) = println(e.message)

    fun showWorkingPlan(plan: Map<Date, Worker>, holidayDecider: HolidayDecider) {
        plan.forEach { (date, worker) ->
            val isHoliday = when (holidayDecider.isWeekdayAndLegalHoliday(date)) {
                true -> HOLIDAY
                false -> ""
            }
            println("${date.month.value}$MONTH ${date.date}$DAY ${date.day.value}${isHoliday} ${worker.name}")
        }
    }

    companion object {
        const val HOLIDAY = "(휴일)"
        const val MONTH = "월"
        const val DAY = "일"
    }
}