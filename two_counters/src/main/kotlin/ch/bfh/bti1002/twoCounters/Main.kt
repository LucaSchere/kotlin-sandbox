package ch.bfh.bti1002.twoCounters

import javafx.geometry.Pos
import javafx.stage.Stage
import tornadofx.*

class ButtonApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = 500.0
        stage.height = 300.0
        super.start(stage)
    }
}


class MainView : View("Böttn") {
    override val root = hbox(alignment = Pos.CENTER)
    private var a = 0
    private var b = 0

    private val ab = button ("A" ) { action { la.text = "A: ${++a}" }}
    private val la = label()
    private val bb = button ("B" ) { action { lb.text = "B:  ${++b}" }}
    private val lb =  label()
}

fun main(args: Array<String>) {
    launch<ButtonApp>(args)
}
