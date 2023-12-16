package oncall.domain

import oncall.domain.data.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OnCallPlannerTest {

    private val onCallPlanner = OnCallPlanner(SequenceRearranger(), SequenceMaker(HolidayDecider()))

    @Test
    fun `최종 비상 근무 계획표를 얻는 통합 테스트`() {
        val date = Date(Month(5), 1, Week.MONDAY)
        val weekdaySequence = WorkerSequence(
            listOf(Worker("a"), Worker("b"), Worker("c"), Worker("d"), Worker("e"), Worker("f"))
        )
        val holidaySequence = WorkerSequence(
            listOf(Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"))
        )
        val result = onCallPlanner.makeTotalWorkingPlan(date, weekdaySequence, holidaySequence)
        println(result)
        val expected = FinalWorkers(
            listOf(
                Worker("a"), Worker("b"), Worker("c"), Worker("d"), Worker("e"), Worker("d"), Worker("f"),
                Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"), Worker("a"), Worker("b"),
                Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("b"), Worker("c"), Worker("d"),
                Worker("c"), Worker("d"), Worker("e"), Worker("f"), Worker("a"), Worker("e"), Worker("f"),
                Worker("b"), Worker("c"), Worker("d"),
            )
        )
        Assertions.assertThat(result).isEqualTo(expected)
    }
}