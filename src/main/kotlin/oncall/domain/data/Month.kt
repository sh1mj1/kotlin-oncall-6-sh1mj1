package oncall.domain.data

data class Month(val value: Int) {
    init {
        require(value in 1..12) {
            INVALID_MONTH
        }
    }

    companion object {
        const val INVALID_MONTH = "[ERROR] 올바르지 않은 월을 입력했습니다. 다시 입력해주세요."
    }
}
