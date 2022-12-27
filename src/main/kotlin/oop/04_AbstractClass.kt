package oop


class myCar(maxSpeed: Double) : Vehicle(maxSpeed) {
    override fun accelerate() {
        this.currentSpeed += 1
    }
}

fun mainCars(): Unit {
    var speed =0.0
    while (speed <= 0.0) {
        println("Enter the max speed:")
        val help = readLine()?.toDoubleOrNull()
        if (help != null)
            speed = help
    }
    val car = myCar(speed)
    //car.currentSpeed = 6.0  //should not be possible
    println("Current Speed: ${car.currentSpeed}")
    println("Max Speed: ${car.maxSpeed}")
    car.pedalToTheMetal()
    println("Current Speed: ${car.currentSpeed}")
}

abstract class Vehicle (val maxSpeed: Double){
    var currentSpeed: Double = 0.0
        protected set

    abstract fun accelerate();
    fun pedalToTheMetal(){
        while(currentSpeed < maxSpeed){
            accelerate();
        }
    }
}
