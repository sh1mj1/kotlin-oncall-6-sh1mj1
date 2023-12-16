package oncall.domain

import oncall.domain.data.Worker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SequenceRearrangerTest {


    private val sequenceRearranger = SequenceRearranger()

    @Test
    fun `연속되는 근무 순서를 재조정해준다`() {
        val originalSequence = listOf(
            Worker("a"),Worker("b"),Worker("c"),Worker("d"),Worker("d"),Worker("e"),Worker("e"),
        )
        val result = sequenceRearranger.rearrange(originalSequence)

        assertThat(result).isEqualTo(
            listOf(
                Worker("a"),Worker("b"),Worker("c"),Worker("d"),Worker("e"),Worker("d"),Worker("e"),
                )
        )
    }
}