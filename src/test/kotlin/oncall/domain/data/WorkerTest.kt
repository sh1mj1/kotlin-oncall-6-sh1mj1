package oncall.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorkerTest {
    @Test
    fun `너무 긴 이름을 입력하면 예외를 던진다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Worker("너무긴이름이다")
        }
        assertThat(exception.message).isEqualTo("[ERROR] 올바르지 않은 근무자 이름이 있습니다. 다시 입력해주세요.")
    }
}