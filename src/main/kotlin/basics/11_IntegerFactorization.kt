package basics

fun integerFactorization(number: Int): List<Int> {
    val factors = mutableListOf<Int>()
    var d = 2
    var n = number
    while (d * d <= n) {
        if (n % d == 0) {
            factors.add(d)
            n /= d
        } else {
            d++
        }
    }
    if (n > 1) {
        factors.add(n)
    }
    return factors
}
