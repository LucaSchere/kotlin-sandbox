package ch.bfh.bti1002.button_animation

import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import tornadofx.*

class ButtonAnimationApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = 500.0
        stage.height = 500.0
        super.start(stage)
    }
}

class MainView : View("ButtonAnimation") {
    private var yesButton = Button("Yes")
    private val noButton = Button("No")
    private val maybeButton = Button("Maybe")
    override val root = GridPane()

    init {

        this += label {
            text = "Will you attend?"
            gridpaneConstraints {
                columnRowIndex(1, 1)
                columnSpan = 6
                padding = Insets(20.0)
                useMaxWidth = true
            }
        }

        this.yesButton.gridpaneConstraints {
            columnRowIndex(0, 3)
            columnSpan = 2
            margin = Insets(20.0)
        }
        this.noButton.gridpaneConstraints {
            columnRowIndex(2, 3)
            columnSpan = 2
            margin = Insets(20.0)
        }
        this.maybeButton.gridpaneConstraints {
            columnRowIndex(4, 3)
            columnSpan = 2
            margin = Insets(20.0)
        }

        this += yesButton
        this += noButton
        this += maybeButton
    }

    private fun onYes() {
        val height = this.yesButton.height
        val width = this.yesButton.width
        this.yesButton = Button("Yes 2")
        this += yesButton
        this.onRefresh()
    }

    fun onNo() {

    }

    fun onMaybe() {

    }

}

fun main(args: Array<String>) {
    launch<ButtonAnimationApp>(args)
}
