package oncall.controller

import oncall.domain.data.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DomainConverterKtTest {

    @Test
    fun `월과 요일을 Date 로 변환한다`() {
        val monthAndDay = 5 to "일"
        val result = monthAndDay.toDate()

        assertThat(result).isEqualTo(Date(Month(5), 1, Week.MONDAY))
    }

    @Test
    fun `문자 리스트를 근무자 순번으로 변환한다`() {
        val workerStr = listOf("aa", "bb", "cc")
        val result = workerStr.toWorkerSequence()

        assertThat(result).isEqualTo(
            WorkerSequence(
                listOf(
                    Worker("aa"), Worker("bb"), Worker("cc"),
                )
            )
        )
    }
}