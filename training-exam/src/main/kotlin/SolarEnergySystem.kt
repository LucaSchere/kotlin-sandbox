import java.lang.Exception

class SolarEnergySystem (var capacity: Double, var area: Double, var chargingLevel: Double = 0.0) {

    // per quadratic meter (area)
    fun sunshine(energy: Double) {
        val toAdd = energy * area
        if (chargingLevel + toAdd > capacity) throw Exception("Charging over capacity")
        chargingLevel += toAdd
    }

    fun consume(energy: Double) {
        if (chargingLevel - energy < 0) throw Exception("Battery empty")
        chargingLevel -= energy
    }

    override fun toString(): String {
        return "SolarEnergySystem(capacity=$capacity, area=$area, chargingLevel=$chargingLevel) \n"
    }
}
