package oncall.domain.data

data class Worker(val name: String) {
    init {
        require(name.length in 1..5) {
            INVALID_NAME
        }
    }

    companion object {
        const val INVALID_NAME = "[ERROR] 올바르지 않은 근무자 이름이 있습니다. 다시 입력해주세요."
    }
}