package oncall.controller

import oncall.config.ExceptionConfig.UNKNOWN_ERROR
import oncall.domain.data.*


fun Pair<Int, String>.toDate(): Date {
    val month = Month(this.first)
    val day = Week.fromString(this.second)
    return Date(month, 1, day)
}

fun List<String>.toWorkerSequence(): WorkerSequence {
    val workers = mutableListOf<Worker>()
    this.forEach {
        workers.add(Worker(it))
    }
    return WorkerSequence(workers)
}

fun <T, U> listsToMap(list1: List<T>, list2: List<U>): Map<T, U> {
    require(list1.size == list2.size) {
        UNKNOWN_ERROR
    }
    return list1.zip(list2).toMap()
}