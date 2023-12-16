package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.Month
import oncall.domain.data.Week
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HolidayDeciderTest {

    private val holidayDecider = HolidayDecider()

    @Test
    fun `주말을 입력했을 때에는 휴일이다`() {
        val date = Date(month = Month(1), date = 3, day = Week.SUNDAY)
        val result = holidayDecider.isHoliday(date)

        assertThat(result).isTrue
    }

    @Test
    fun `주말이 아니지만 공휴일이면 휴일이다`() {
        val date = Date(month = Month(1), date = 1, day = Week.MONDAY)
        val result = holidayDecider.isHoliday(date)

        assertThat(result).isTrue
    }

    @Test
    fun `공휴일 아닌 평일을 입력했을 때에는 휴일 아니다`() {
        val date = Date(month = Month(1), date = 8, day = Week.MONDAY)
        val result = holidayDecider.isHoliday(date)

        assertThat(result).isFalse
    }
}