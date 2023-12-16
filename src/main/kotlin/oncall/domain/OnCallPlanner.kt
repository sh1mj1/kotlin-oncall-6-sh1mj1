package oncall.domain

import oncall.domain.data.Date
import oncall.domain.data.FinalWorkers
import oncall.domain.data.WorkerSequence

class OnCallPlanner(private val sequenceRearranger: SequenceRearranger, private val sequenceMaker: SequenceMaker) {

    fun makeTotalWorkingPlan(date: Date, weekdayWorkers: WorkerSequence, holidayWorkers: WorkerSequence): FinalWorkers {
        val sequence = sequenceMaker.makeSequence(date, weekdayWorkers, holidayWorkers)
        return sequenceRearranger.rearrange(sequence.workers)
    }

}