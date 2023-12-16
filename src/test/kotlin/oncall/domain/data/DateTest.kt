package oncall.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DateTest {

    @Test
    fun `다음 Date 테스트`() {
        val date = Date(Month(1), 1, Week.MONDAY)
        val result = date.nextDate()

        assertThat(result).isEqualTo(Date(Month(1), 2, Week.TUESDAY))
    }

    @Test
    fun `현재 월의 마지막 일 테스트`() {
        val date = Date(Month(1), 1, Week.MONDAY)
        val result = date.lastDate()

        assertThat(result).isEqualTo(31)
    }

    @Test
    fun `현재 달의 모든 날을 구하는 테스트`() {
        val date = Date(Month(2), 1, Week.MONDAY)
        val result = date.getDatesInThisMonth()

        assertThat(result).isEqualTo(
            listOf(
                Date(Month(2), 1, Week.MONDAY),
                Date(Month(2), 2, Week.TUESDAY),
                Date(Month(2), 3, Week.WEDNESDAY),
                Date(Month(2), 4, Week.THURSDAY),
                Date(Month(2), 5, Week.FRIDAY),
                Date(Month(2), 6, Week.SATURDAY),
                Date(Month(2), 7, Week.SUNDAY),

                Date(Month(2), 8, Week.MONDAY),
                Date(Month(2), 9, Week.TUESDAY),
                Date(Month(2), 10, Week.WEDNESDAY),
                Date(Month(2), 11, Week.THURSDAY),
                Date(Month(2), 12, Week.FRIDAY),
                Date(Month(2), 13, Week.SATURDAY),
                Date(Month(2), 14, Week.SUNDAY),

                Date(Month(2), 15, Week.MONDAY),
                Date(Month(2), 16, Week.TUESDAY),
                Date(Month(2), 17, Week.WEDNESDAY),
                Date(Month(2), 18, Week.THURSDAY),
                Date(Month(2), 19, Week.FRIDAY),
                Date(Month(2), 20, Week.SATURDAY),
                Date(Month(2), 21, Week.SUNDAY),

                Date(Month(2), 22, Week.MONDAY),
                Date(Month(2), 23, Week.TUESDAY),
                Date(Month(2), 24, Week.WEDNESDAY),
                Date(Month(2), 25, Week.THURSDAY),
                Date(Month(2), 26, Week.FRIDAY),
                Date(Month(2), 27, Week.SATURDAY),
                Date(Month(2), 28, Week.SUNDAY),
            )
        )
    }
}