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