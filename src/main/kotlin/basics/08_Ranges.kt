package basics

fun stats(range: IntProgression = 1..10 step 1) {
    println("range: $range")

    val asArray = range.toList().toIntArray()   ;

    // number of elements
    val numberOfElements = asArray.size;
    println("number of elements: $numberOfElements")

    // sum
    val sum = asArray.sum();
    println("sum: $sum")

    // product
    var product = 1;
    for (int in asArray)
        product *= int

    println("product: $product")

    // average
    val avg = 1.0 * sum / numberOfElements
    println("avg: $avg")

    // median
    val median = if (asArray.size % 2 == 0) {
        (asArray[asArray.size / 2 - 1] + asArray[asArray.size / 2]) / 2.0
    } else {
        asArray[asArray.size / 2].toDouble();
    }
    println("median: $median")
}
