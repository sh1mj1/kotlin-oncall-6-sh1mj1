package oncall.domain.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorkerSequenceTest {

    @Test
    fun `중복된 근무자가 있을 시 예외를 던짐`() {
        val exception = assertThrows<IllegalArgumentException> {
            WorkerSequence(
                listOf(
                    Worker("심지1"),
                    Worker("심지2"),
                    Worker("심지3"),
                    Worker("심지4"),
                    Worker("심지5"),
                    Worker("심지1"),
                )
            )
        }
        assertThat(exception.message).isEqualTo("[ERROR] 근무자가 순번에 중복하여 들어가 있습니다. 다시 입력해주세요.")
    }
}