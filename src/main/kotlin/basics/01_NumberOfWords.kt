package basics

fun numberOfWords(text: String): Int {
    if (text.isEmpty()) return 0;
    var count = 0;
    var lastChar = text[0];

    for (c in text) {
        if (!isAlphabet(c) && isAlphabet(lastChar)) count++;
        lastChar = c;
    }
    if (isAlphabet(lastChar)) count++;
    return count;
}

fun isAlphabet(c: Char): Boolean {
    return c in 'a'..'z' || c in 'A'..'Z';
}
