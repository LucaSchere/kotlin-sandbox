package basics

import kotlin.random.Random
import kotlin.random.nextInt

fun randomArray() {
    val arr = Array(100) { _ -> Random.nextInt(1..100) }

    for (int in arr)
        println(int)
}

fun randomUniqueArray(n: Int) {
    val arr = (1..100).shuffled().take(n).toList().toIntArray()
    for (int in arr)
        println(int)
}

fun randomUniqueArrayNonApi() {
    val source = (1..100).toList().toMutableList()
    val out = Array<Int>(100) { i -> i + 1}

    out.forEachIndexed { index, _ ->
        val value = source.shuffled().take(1)[0];
        out[index] = value;
        source.removeIf {it === value}
    }

    for (int in out)
        println(int)
}
