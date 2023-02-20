package ch.bfh.bti1002.flags

import javafx.scene.paint.Color
import javafx.stage.Stage
import tornadofx.*

class FlagsApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = 250.0
        stage.height = 250.0
        super.start(stage)
    }
}

class MainView : View("Flags") {
    override val root = stackpane {
        rectangle { x=0.0; y=0.0; width=200.0; height=200.0; fill= Color.RED
            rectangle { width=35.0; height=120.0; fill=Color.WHITE }
            rectangle { width=120.0; height=35.0; fill=Color.WHITE }
        }
    }
}

fun main(args: Array<String>) {
    launch<FlagsApp>(args)
}
