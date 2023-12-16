package oncall.domain.data

import oncall.config.ExceptionConfig.ERROR_HEADER

data class WorkerSequence(val workers: List<Worker>) {
    init {
        require(workers.size == workers.toSet().size) {
            DUPLICATED_WORKERS
        }
    }

    companion object {
        const val DUPLICATED_WORKERS = "$ERROR_HEADER 근무자가 순번에 중복하여 들어가 있습니다. 다시 입력해주세요."
    }
}
