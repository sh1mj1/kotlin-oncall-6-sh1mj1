package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.Holiday
import oncall.domain.data.Month
import oncall.domain.data.Week

class HolidayDecider {
    fun isHoliday(date: Date): Boolean {
        if (isWeekend(date)) {
            return true
        }
        if (Holiday.holidays.any { isLegalHoliday(it, date) }) {
            return true
        }
        return false
    }

    fun isWeekdayAndLegalHoliday(date: Date): Boolean {
        if ((!isWeekend(date)) && (Holiday.holidays.any { isLegalHoliday(it, date) })
        ) return true

        return false
    }

    private fun isWeekend(date: Date) = date.day == Week.SATURDAY || date.day == Week.SUNDAY

    private fun isLegalHoliday(it: Pair<Month, Int>, date: Date) =
        it.first == date.month && it.second == date.date
}