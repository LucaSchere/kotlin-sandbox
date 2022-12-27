package oop

fun testTerm() {
    println(
        BinaryExpression(
            BinaryExpression(
                Constant(3.0),
                BinaryOperator.ADDITION,
                UnaryExpression(
                    Variable("d"),
                    UnaryOperator.NEGATE
                )
            ),
            BinaryOperator.MULTIPLICATION,
            Constant(5.0)
        ).eval()
    )
}

abstract class Term {
    abstract fun eval(): Double
}

class Constant(private val value: Double) : Term() {
    override fun eval(): Double {
        return value;
    }
}

class Variable(private val name: String) : Term() {
    override fun eval(): Double {
        return when (name) {
            "d" -> 7.0
            else -> 0.0
        }
    }
}

class UnaryExpression(private val term: Term, private val op: UnaryOperator) : Term() {
    override fun eval(): Double {
        return when (op) {
            UnaryOperator.NEGATE -> -term.eval()
        }
    }
}

class BinaryExpression(private val left: Term, private val op: BinaryOperator, private val right: Term) : Term() {
    override fun eval(): Double {
        return when (op) {
            BinaryOperator.ADDITION -> left.eval() + right.eval()
            BinaryOperator.SUBTRACTION -> left.eval() - right.eval()
            BinaryOperator.MULTIPLICATION -> left.eval() * right.eval()
            BinaryOperator.DIVISION -> left.eval() / right.eval()
        }
    }
}

enum class UnaryOperator {
    NEGATE
}

enum class BinaryOperator {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION
}
