
package ch.bfh.bti1002.training

import java.lang.Exception

class SolarEnergySystem (var capacity: Double, var area: Double, var chargingLevel: Double = 0.0) {

    val historyItems = ArrayList<HistoryItem>()

    fun getHistory(): List<HistoryItem> {
        val drop = historyItems.size - 5
        return historyItems.drop(if(drop < 0) 0 else drop)
    }

    // per quadratic meter (area)
    fun sunshine(energy: Double) {
        try {
            val toAdd = energy * area
            if (chargingLevel + toAdd > capacity) throw Exception("Charging over capacity")
            chargingLevel += toAdd
            historyItems.add(HistoryItem(Method.Sunshine, energy, State.NORMAL, chargingLevel))
        } catch (_: Exception) {
            historyItems.add(HistoryItem(Method.Sunshine, energy, State.EXCEPTION, chargingLevel))
        }
    }

    fun consume(energy: Double) {
        try {
            if (chargingLevel - energy < 0) throw Exception("Battery empty")
            chargingLevel -= energy
            historyItems.add(HistoryItem(Method.Consume, energy, State.NORMAL, chargingLevel))
        } catch (_: Exception) {
            historyItems.add(HistoryItem(Method.Consume, energy, State.EXCEPTION, chargingLevel))
        }
    }

    override fun toString(): String {
        return "SolarEnergySystem(capacity=$capacity, area=$area, chargingLevel=$chargingLevel) \n"
    }
}
