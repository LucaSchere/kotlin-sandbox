package basics

fun middleSquareMethod(seed: Int, n: Int): Int {
    var result = seed;
    for (i in 1..n) {
        result *= result;
        result /= 100
        result %= 10000;
    }
    return result;
}
