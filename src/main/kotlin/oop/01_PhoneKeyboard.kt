package oop

fun dial() {
    val phoneKeyboard = PhoneKeyboard()
    phoneKeyboard.press('0')
    phoneKeyboard.press('7')
    phoneKeyboard.press('9')
    phoneKeyboard.press('1')
    phoneKeyboard.press('7')
    phoneKeyboard.press('1')
    phoneKeyboard.press('4')
    phoneKeyboard.press('2')
    phoneKeyboard.press('1')
    phoneKeyboard.press('1')

    phoneKeyboard.backspace()
    phoneKeyboard.press('2')

    //phoneKeyboard.clear()

    phoneKeyboard.dial()
}

class PhoneKeyboard() {

    private val phoneNumber: MutableList<String> = mutableListOf<String>()

    fun press(char: Char) {
        if (!char.isDigit()) return;
        this.phoneNumber.add(char.toString())
    }

    fun backspace() {
        this.phoneNumber.removeAt(this.phoneNumber.size - 1)
    }

    fun clear() {
        this.phoneNumber.clear()
    }

    fun dial() {
        if (this.phoneNumber.size >= 10)
            println("calling ${this.phoneNumber.joinToString("")}")
    }
}
