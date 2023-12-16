package oncall.controller

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
        "[ERROR] 예기치 못한 오류가 발생했습니다. 관리자에게 문의하세요."
    }
    return list1.zip(list2).toMap()
}