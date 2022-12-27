package basics

fun extractTable() {
    val table = """
    |-----|----------|
    | Nb. | Quantity |
    |-----|----------|
    | 1   |    34    |
    | 2   |    128   |
    | 3   |    7     |
    | 4   |    5698  |
    | 5   |    29    |
    |-----|----------| ;
""";
    val newLineRegex = "\r?\n|\r".toRegex()
    val numberRegex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    val stringFormat = "%8.8s";
    var sum = 0;

    val rows = table.split(newLineRegex).toTypedArray()
    for (row in rows) {
        if (!row.contains('|')) continue;
        val cells = row.split('|')
        if (cells.size < 3) continue
        val cellValue = cells[2].trim()

        if (cellValue.matches(numberRegex)) {
            println(String.format(stringFormat, cellValue))
            sum += cellValue.toInt();
        }
    }
    println("========")
    println(String.format(stringFormat, sum));
}
