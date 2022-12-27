package oop

fun compare() {
    val car1 = Car(5.0, 50.0)
    val car2 = Car(3.0)

    car1.fillTank(50.0)
    car2.fillTank(20.0)

    car1.drive(100.0)
    car2.drive(150.0)

    println("Car 1: ${car1.tank} liters")
    println("Car 2: ${car2.tank} liters")
}

class Car (private val litersPerAHundredKm: Double, private val tankCapacity: Double = 30.0) {
    var tank: Double = 0.0

    fun fillTank(liters: Double) {
        if (this.tank + liters <= this.tankCapacity) {
            this.tank += liters
        } else {
            println("Cannot fill tank with $liters liters. Tank capacity is $tankCapacity")
        }

        println("Tank level: ${this.tank}l")
    }

    fun drive(km: Double) {
        val litersNeeded = km * litersPerAHundredKm / 100
        if (this.tank < litersNeeded) {
            println("Not enough fuel to drive $km km")
            return
        }
        this.tank -= litersNeeded
        println("The car drove $km km")
    }


}
