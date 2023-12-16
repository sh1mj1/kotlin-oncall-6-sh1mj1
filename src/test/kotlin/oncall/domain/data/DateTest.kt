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
}