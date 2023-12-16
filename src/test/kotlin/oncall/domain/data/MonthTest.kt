package oncall.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MonthTest {
    @Test
    fun `올바르지 않은 월 입력 시 예외 던짐`() {
        val exception = assertThrows<IllegalArgumentException> {
            Month(13)
        }
        assertThat(exception.message).isEqualTo("[ERROR] 올바르지 않은 월을 입력했습니다. 다시 입력해주세요.")
    }
}