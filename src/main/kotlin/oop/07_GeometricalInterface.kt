package oop
import kotlin.math.PI
import kotlin.math.pow

interface Geometrical {
    val area: Double
    val perimeter: Double

    fun print() {
        println("area: $area, perimeter: $perimeter")
    }

    fun isPolygon (): Boolean {return false}
}

class Square(private val s: Double) : Geometrical {
    override val area: Double
        get() = s.pow(2)

    override val perimeter: Double
        get() = s * 4

    override fun isPolygon(): Boolean {
        return true
    }
}

class Circle(private val radius: Double) : Geometrical {
    override val area: Double
        get() = radius.pow(2) * PI

    override val perimeter: Double
        get() = radius * 2 * PI

}


fun testGeo() {
    val array = arrayOf(Circle(2.0), Square(5.0))

    for(i in array)
        i.print()
}
