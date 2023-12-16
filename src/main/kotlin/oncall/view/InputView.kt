package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readMonthAndDay(): Pair<Int, String> {
        print(ASK_MONTH_AND_DAY)
        val monthAndDayStr = Console.readLine()
        require(monthAndDayStr.isNotBlank()) { INVALID_INPUT }

        val monthAndDay = monthAndDayStr.split(ASK_DELIMITER)
        require(monthAndDay.size == 2) { INVALID_INPUT }

        requireNotNull(monthAndDay[0].toIntOrNull()) { INVALID_INPUT }
        return (monthAndDay[0].toInt() to monthAndDay[1])
    }

    fun readWeekDaysWorkers(): List<String> {
        print(ASK_WEEKDAY_WORK_SEQUENCE)
        return readWorkers()
    }

    fun readHolidaysWorkers(): List<String> {
        print(ASK_HOLIDAY_WORK_SEQUENCE)
        return readWorkers()
    }


    private fun readWorkers(): List<String> {
        val workerStr = Console.readLine()
        require(workerStr.isNotBlank()) { INVALID_INPUT }

        val workers = workerStr.split(ASK_DELIMITER)
        workers.forEach {
            require(it.isNotBlank())
        }
        return workers
    }

    companion object {
        const val ASK_MONTH_AND_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val INVALID_INPUT = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
        const val ASK_WEEKDAY_WORK_SEQUENCE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val ASK_HOLIDAY_WORK_SEQUENCE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "

        const val ASK_DELIMITER = ","
    }

}