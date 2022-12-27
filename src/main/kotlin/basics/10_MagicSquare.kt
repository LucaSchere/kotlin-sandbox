package basics

fun magicSquare(n: Int) {
    if (n % 2 == 0) return
    val magicSquare = Array(n) { IntArray(n) }
    var col = n / 2 - 1
    var row = n - 1 - 1
    for (i in 1..n * n) {
        row++
        col++

        if (row == n) row = 0
        if (col == n) col = 0

        if (row == 0 && col == 0) {
            row = n - 2
            col = n - 1
        }

        if (magicSquare[row][col] != 0) {
            row -= 2
            col--
            if (row < 0) row = n - row
            if (col < 0) col = n - 1
        }

        magicSquare[row][col] = i
    }
    for (o in magicSquare.indices)
        println(magicSquare[o].contentToString())
}

fun magicSquare2(n: Int) {
    if (n % 2 == 0) return
    val magicSquare = Array(n) { IntArray(n) }
    var col = n / 2
    var row = n - 1
    for (i in 1..n * n) {
        magicSquare[row][col] = i
        row = (row + 1) % n
        col = (col + 1) % n
        if (magicSquare[row][col] != 0) {
            row = (row - 1 + n) % n
            col = (col - 2 + n) % n
        }
    }
    for (o in magicSquare.indices)
        println(magicSquare[o].contentToString())
}
