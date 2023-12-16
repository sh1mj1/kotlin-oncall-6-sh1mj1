package oncall.domain.data

import oncall.config.ExceptionConfig.ERROR_HEADER

data class FinalWorkers(val workers: List<Worker>) {
    init {
        require(workers.toSet().size >= 5) { NEED_MORE_WORKERS }
        require(workers.toSet().size <= 35) { TOO_MANY_WORKERS }
    }

    companion object {
        const val NEED_MORE_WORKERS = "$ERROR_HEADER 근무자가 너무 적습니다."
        const val TOO_MANY_WORKERS = "$ERROR_HEADER 근무자가 너무 많습니다."
    }
}