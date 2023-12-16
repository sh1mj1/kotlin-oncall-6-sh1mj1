package oncall.domain

import oncall.domain.data.Worker

class SequenceRearranger {

    fun rearrange(workingSequence: List<Worker>): MutableList<Worker> {
        val sequence = workingSequence.toMutableList()

        var needToCheck = true
        while (needToCheck) {
            needToCheck = false
            for (i in 0 until sequence.size - 1) {
                if (sequence[i] == sequence[i + 1]) {
                    if (i + 2 < sequence.size) {
                        sequence[i + 1] = sequence[i + 2].also { sequence[i + 2] = sequence[i + 1] }
                    }
                    needToCheck = true
                    break
                }
            }
        }
        return sequence
    }

}