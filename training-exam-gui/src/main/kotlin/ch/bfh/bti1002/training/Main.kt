package ch.bfh.bti1002.training

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Label
import javafx.stage.Stage
import tornadofx.*

class SolarApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = 700.0
        stage.height = 700.0
        super.start(stage)
    }
}

class MainView : View("SolarSystem") {

    val solarSystem = SolarEnergySystem(300.0, 10.0)
    val input = SimpleStringProperty()
    val normalState = "All works normal."

    var level = label {
        text = ""
    }

    var state = label {
        text=""
    }

    var history: ArrayList<Label> = ArrayList()

    init {
        setHistory()
    }

    fun setHistory() {
        for (i in history) {
            i.removeFromParent()
        }
        history.clear()

        for (i in solarSystem.getHistory()) {
            history.add(label { text=i.toString() })
        }
    }

    fun parseState(list: List<HistoryItem>): String {
        if (list.isEmpty()) return normalState
        if (list.last().state == State.NORMAL) return normalState
        return "Exception"
    }

    fun setState() {
        state.text=parseState(solarSystem.getHistory())
        if (!solarSystem.getHistory().isEmpty() && solarSystem.getHistory().last().state == State.EXCEPTION) state.textFill = c("red")
    }

    fun setLevel() {
        level.text = "Charging Level: ${solarSystem.chargingLevel}"
    }

    fun update() {
        setLevel()
        setState()
        setHistory()
    }

    override val root = vbox {
        label {
            text = "Solar Energy System - Capacity: ${solarSystem.capacity}, Area: ${solarSystem.area}"
            textFill = c("green")
        }
        this.add(level)
        form {

            fieldset {
                field("Quantity") {
                    textfield(input) {
                        filterInput { it.controlNewText.isDouble() }
                    }
                }
                button("sunshine") {
                    action {
                        solarSystem.sunshine(input.value.toDouble())
                        level.text("Charging Level: ${solarSystem.chargingLevel}")
                        input.value = ""
                        update()

                    }
                }
                button("consume") {
                    action {
                        solarSystem.consume(input.value.toDouble())
                        level.text("Charging Level: ${solarSystem.chargingLevel}")
                        input.value = ""
                        update()
                    }
                }
            }
        }

        for (i in history) {
            this.add(i)
        }
        this.add(state)


    }
}


fun main(args: Array<String>) {
    launch<SolarApp>(args)
}
