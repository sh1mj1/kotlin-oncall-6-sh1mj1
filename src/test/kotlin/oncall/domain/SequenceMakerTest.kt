package oncall.domain

import oncall.domain.data.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SequenceMakerTest {

    val sequenceMaker = SequenceMaker(HolidayDecider())

    @Test
    fun `평일과 휴일 순번을 가지고 근무 순번을 만든다`() {
        val date = Date(Month(5), 1, Week.MONDAY)
        val weekdaySequence = WorkerSequence(
            listOf(Worker("a"), Worker("b"), Worker("c"), Worker("d"), Worker("e"), Worker("f"))
        )
        val holidaySequence = WorkerSequence(
            listOf(Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"))
        )

        val result = sequenceMaker.makeSequence(date, weekdaySequence, holidaySequence)
        println(result)
        val expected = listOf(
            Worker("a"), Worker("b"), Worker("c"), Worker("d"), Worker("d"), Worker("e"), Worker("f"),
            Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"), Worker("a"), Worker("b"),
            Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"), Worker("d"),
            Worker("c"), Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("e"), Worker("f"),
            Worker("b"), Worker("c"), Worker("d"),
        )
        assertThat(result).isEqualTo(expected)
    }
}