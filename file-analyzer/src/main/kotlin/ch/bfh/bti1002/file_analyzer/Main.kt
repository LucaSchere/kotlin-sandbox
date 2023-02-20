package ch.bfh.bti1002.file_analyzer

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.stage.FileChooser
import javafx.stage.Stage
import tornadofx.*
import java.io.File

class FileAnalyzerApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.width = 500.0
        stage.height = 500.0
        super.start(stage)
    }
}

class MainView : View("File Analyzer") {

    private val path = SimpleStringProperty(chooseFile(
        "Choose a file",
        arrayOf(FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")),
    )[0].absolutePath)

    val fileContent = File(path.value).readText()

    private val nCharacters = SimpleIntegerProperty(fileContent.toByteArray().size)
    private val nWords = SimpleIntegerProperty(fileContent.split(" ").size)
    private val nLines = SimpleIntegerProperty(fileContent.split("\r").size)

    override val root = vbox {
        button {
            text = "Analyze"
        }
        label {
            bind(path)
        }

        form {
            fieldset {
                field("Characters") {
                    textfield {
                        bind(nCharacters)
                    }
                }
                field("Words") {
                    textfield {
                        bind(nWords)
                    }
                }
                field("Lines") {
                    textfield {
                        bind(nLines)
                    }
                }
            }
        }


    }
}

fun main(args: Array<String>) {
    launch<FileAnalyzerApp>(args)
}
