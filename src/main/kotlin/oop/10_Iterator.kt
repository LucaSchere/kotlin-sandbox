package oop

fun testIterator() {
    val it = StringTableIterator(
        arrayOf(
            arrayOf("a", "b", "c"),
            arrayOf("d", "e", "f"),
            arrayOf("g", "h", "i")
        )
    )

    while (it.hasNext()) {
        println(it.next())
    }
}

interface Iterator {
    var position: Int
    fun hasNext(): Boolean
    fun next(): Any
    fun reset()
}

class StringIterator(private val string: String): Iterator {
    override var position: Int = 0
    private var chars: CharArray = string.toCharArray()

    override fun hasNext(): Boolean {
        return chars.getOrNull(position) !== null
    }

    override fun next(): Char {
        if (!hasNext()) throw NoSuchElementException()
        val char = chars[position]
        position++
        return char
    }

    override fun reset() {
        position = 0
    }

}

class DigitsIterator(private val range: IntRange = 0..10): Iterator {
    override var position: Int = 0
    private val digits = range.toList().toIntArray()

    override fun hasNext(): Boolean {
        return digits.getOrNull(position) !== null
    }

    override fun next(): Int {
        if (!hasNext()) throw NoSuchElementException()
        val digit = digits[position]
        position++
        return digit
    }

    override fun reset() {
        position = 0
    }
}

class StringListIterator(private val list: List<String>): Iterator {
    override var position: Int = 0

    override fun hasNext(): Boolean {
        return list.getOrNull(position) !== null
    }

    override fun next(): String {
        if (!hasNext()) throw NoSuchElementException()
        val string = list[position]
        position++
        return string
    }

    override fun reset() {
        position = 0
    }
}

class StringTableIterator(private val table: Array<Array<String>>): Iterator {
    override var position: Int = 0
    private val flat = table.flatten().toTypedArray();

    override fun hasNext(): Boolean {
        return flat.getOrNull(position) !== null
    }

    override fun next(): String {
        if (!hasNext()) throw NoSuchElementException()
        val string = flat[position]
        position++
        return string
    }

    override fun reset() {
        position = 0
    }
}
