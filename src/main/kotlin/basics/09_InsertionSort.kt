package basics

fun insertionSort(array: IntArray) {

    for (i in 1 until array.size) {
        val curr = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > curr) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = curr
    }
    println(array.contentToString())
}
