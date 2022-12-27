package basics


fun alternatingCase(s: String): String {
    var result = "";
    for (i in s.indices) {
        if (!s[i].isLetter()) continue;
        result += when {
            i % 2 == 0 -> s[i].uppercaseChar();
            else -> s[i].lowercaseChar();
        }
    }
    return result;
}

fun alternatingCaseRecursive(s: String): String {
    if (s.isEmpty() || !s[0].isLetter()) return "";
    val curr = if (s.length % 2 == 0) s[0].uppercaseChar() else s[0].lowercaseChar();
    return curr + alternatingCaseRecursive(s.substring(1).lowercase());
}
