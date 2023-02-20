package ch.bfh.bti1002.worldsHighestBuildings

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import tornadofx.*

const val HEIGHT = 700.0
const val WIDTH = 400.0

class WorldsHighestBuildingsApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = WIDTH
        stage.height = HEIGHT
        super.start(stage)
    }
}

enum class Buildings(val height: Double) {
    SearsTower(527.0),
    Taipei101(508.0),
    EmpireStateBuilding(449.0),
    EiffelTower(324.0);
}

class MainView : View("Worlds Highest Buildings") {
    private val padding = 20.0
    private val spacing = 20.0
    private val nOfBuildings = Buildings.values().size
    private val maxHeight = Buildings.values().maxBy { it.height }.height - 2 * padding

    private val width = (WIDTH - 2 * padding - (nOfBuildings-1) * spacing) / nOfBuildings

    override val root = hbox()

    init {
        apply {
            enumValues<Buildings>().forEachIndexed { i, b ->
                this += building( padding + i * (width + spacing), b.name, b.height)
            }
        }
    }

    private fun building(x: Double, name: String, height: Double): Rectangle {
        val accHeight = height / this.maxHeight * HEIGHT
        val r = Rectangle()
        r.isManaged = false
        r.fill = Color.ORANGE
        r.x = x
        r.y = 150 + padding + this.maxHeight - accHeight
        r.width = this.width
        r.height = accHeight
        return r
    }
}

fun main(args: Array<String>) {
    launch<WorldsHighestBuildingsApp>(args)
}
