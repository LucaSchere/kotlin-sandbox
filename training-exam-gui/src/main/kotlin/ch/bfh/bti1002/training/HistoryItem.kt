package ch.bfh.bti1002.training

enum class Method {Sunshine, Consume}
enum class State {NORMAL, EXCEPTION}

class HistoryItem(val method: Method, val value: Double, val state: State, val chargingLevel: Double) {
    override fun toString(): String {
        return "[${state.name}] $method + $value:  (new charging level= $chargingLevel)"
    }
}
