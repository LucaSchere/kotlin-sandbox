package oop

fun testRestaurant() {
    val sushiSiech = SushiRestaurant("SushiSiech", 5)
    val danino = PizzeriaItaliana("daNino", 4)

    danino.receivePayment(PaymentType.Cash, 3000.0)
    sushiSiech.receivePayment(PaymentType.Cash, 400.1)
    danino.receivePayment(PaymentType.Visa, 8000.0)

    sushiSiech.hire()
    println(sushiSiech)
    println(danino)
    danino.fire()
    println(danino)
}

enum class PaymentType {
    Cash, Visa, Mastercard
}

interface Payable {
    fun receivePayment(type: PaymentType, amount: Double)
}

interface PayableInCash : Payable {
    fun receiveCash(amount: Double)
}

interface PayableByCard : Payable {
    fun receiveTipInCash(amount: Double)
}

abstract class Restaurant(
    private val name: String,
    private var nOfEmployees: Int,
    protected var money: Double = 0.0,
    protected var cash: Double = 0.0
) {
    abstract fun serveFood(): String

    fun hire() {
        nOfEmployees++
    }

    fun fire() {
        nOfEmployees--
    }

    override fun toString(): String {
        return "name: $name, employees: $nOfEmployees, cash: $cash, money: $money"
    }
}

class SushiRestaurant(name: String, nOfEmployees: Int) : Restaurant(name, nOfEmployees), PayableInCash {
    override fun serveFood(): String {
        return "Sushi"
    }

    override fun receiveCash(amount: Double) {
        cash += amount
    }

    override fun receivePayment(type: PaymentType, amount: Double) {
        if (type === PaymentType.Cash) receiveCash(amount)
    }
}

class PizzeriaItaliana(name: String, nOfEmployees: Int) : Restaurant(name, nOfEmployees), PayableInCash, PayableByCard {
    override fun serveFood(): String {
        return "Pizza"
    }

    override fun receiveCash(amount: Double) {
        cash += amount
    }

    override fun receiveTipInCash(amount: Double) {
        cash+=amount
    }

    override fun receivePayment(type: PaymentType, amount: Double) {
        when (type) {
            PaymentType.Visa -> money+= amount
            PaymentType.Mastercard -> money += amount
            PaymentType.Cash -> receiveCash(amount)
        }

    }
}
