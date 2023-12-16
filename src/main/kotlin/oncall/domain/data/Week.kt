package oncall.domain.data

enum class Week(val value: String) {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일"),
    ;

    fun next(): Week = when (this) {
        MONDAY -> TUESDAY
        TUESDAY -> WEDNESDAY
        WEDNESDAY -> THURSDAY
        THURSDAY -> FRIDAY
        FRIDAY -> SATURDAY
        SATURDAY -> SUNDAY
        SUNDAY -> MONDAY
    }

}