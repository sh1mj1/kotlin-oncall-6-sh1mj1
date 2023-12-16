package oncall

import oncall.controller.OnCallController
import oncall.domain.HolidayDecider
import oncall.domain.OnCallPlanner
import oncall.domain.SequenceMaker
import oncall.domain.SequenceRearranger
import oncall.view.InputView
import oncall.view.OutputView

fun main() {
    val onCallController = OnCallController(
        inputView = InputView(),
        outputView = OutputView(),
        onCallPlanner = OnCallPlanner(
            sequenceRearranger = SequenceRearranger(),
            sequenceMaker = SequenceMaker(
                holidayDecider = HolidayDecider()
            )
        )
    )

    onCallController.start()
}
