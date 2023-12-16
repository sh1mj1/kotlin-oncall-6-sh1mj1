package oncall.domain.data

data class Date(val month: Month, val date: Int, val day: Week) {

    fun lastDate(): Int = when {
        monthHas31Days.contains(month) -> 31
        month28Days.contains(month) -> 28
        month30Days.contains(month) -> 30
        else -> {
            throw IllegalArgumentException(INVALID_DATE)
        }
    }

    fun nextDate(): Date = this.copy(month = month, date = date + 1, day = day.next())

    fun getDatesInThisMonth(): List<Date> {
        val allDates = mutableListOf<Date>()
        var nowDate = this.copy()
        repeat(lastDate()) {
            allDates.add(nowDate)
            nowDate = nowDate.copy(month = month, date = nowDate.date + 1, day = nowDate.day.next())
        }
        return allDates
    }

    companion object {
        val monthHas31Days = listOf(
            Month(1),
            Month(3),
            Month(5),
            Month(7),
            Month(8),
            Month(10),
            Month(12),
        )
        val month28Days = listOf(Month(2))
        val month30Days = listOf(
            Month(4),
            Month(6),
            Month(9),
            Month(11),
        )

        const val INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다."
    }
}