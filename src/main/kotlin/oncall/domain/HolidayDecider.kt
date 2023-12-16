package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.Holiday
import oncall.domain.data.Week

class HolidayDecider {
    fun isHoliday(date: Date): Boolean {
        if (date.day == Week.SATURDAY || date.day == Week.SUNDAY) {
            return true
        }
        if (Holiday.holidays.any {
                it.first == date.month && it.second == date.date
            }) {
            return true
        }
        return false
    }
}