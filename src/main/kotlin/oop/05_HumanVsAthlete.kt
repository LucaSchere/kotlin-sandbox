package oop

import kotlin.math.pow

fun test() {
    val human = Human(76.0,1.76)
    val athlete = Athlete()

    human.run()
    athlete.run()

    println(human.bmi)


    println(human.bmiCategory)
}

enum class BmiCategory(val range: ClosedFloatingPointRange<Double>) {
    UNDERWEIGHT(0.0..18.5), NORMAL(18.8..25.0), OVERWEIGHT(25.0..30.0), OBESE(30.0..Double.MAX_VALUE)
}

open class Human(private val weight: Double = 75.0, private val height: Double = 1.7){
    val bmi: Double
        get() {
            return weight / height.pow(2)
        }

    open val bmiCategory: BmiCategory
        get() {
            return when (bmi) {
                in BmiCategory.UNDERWEIGHT.range -> BmiCategory.UNDERWEIGHT
                in BmiCategory.NORMAL.range -> BmiCategory.NORMAL
                in BmiCategory.OVERWEIGHT.range -> BmiCategory.OVERWEIGHT
                else -> BmiCategory.OBESE
            }
        }

    open fun run() {
        println("Running like a avg. Human")
    }
}

class Athlete: Human(60.0, 1.8) {
    override fun run() {
        println("Running faster")
    }

    override val bmiCategory: BmiCategory
        get() {
            return BmiCategory.NORMAL;
        }
}
