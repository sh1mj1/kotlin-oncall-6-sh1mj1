package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readMonthAndDay(): Pair<Int, String> {
        println("비상 근무를 배정할 월과 시작 요일을 입력하세요>")
        val monthAndDayStr = Console.readLine()
        require(monthAndDayStr.isNotBlank()) { "[ERROR] 입력이 올바르지 않습니다. 다시 입력해주세요." }

        val monthAndDay = monthAndDayStr.split(",")
        require(monthAndDay.size == 2) { "[ERROR] 입력이 올바르지 않습니다. 다시 입력해주세요." }

        requireNotNull(monthAndDay[0].toIntOrNull()) { "[ERROR] 입력이 올바르지 않습니다. 다시 입력해주세요." }
        return (monthAndDay[0].toInt() to monthAndDay[1])
    }

    fun readWeekDaysWorkers(): List<String> {
        print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>")
        return readWorkers()
    }

    fun readHolidaysWorkers(): List<String> {
        print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>")
        return readWorkers()
    }


    private fun readWorkers(): List<String> {
        val workerStr = Console.readLine()
        require(workerStr.isNotBlank()) { "[ERROR] 입력이 올바르지 않습니다. 다시 입력해주세요." }

        val workers = workerStr.split(",")
        workers.forEach {
            require(it.isNotBlank())
        }
        return workers
    }

}