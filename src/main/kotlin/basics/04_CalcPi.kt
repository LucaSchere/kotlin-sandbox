package basics


fun calcPi(): Double {
    var pi = 1.0;
    var sign = -1;
    for (i in 3..100000 step 2) {
        pi += sign * 1.0/i;
        sign *= -1;
    }

    return pi * 4;
}

fun calcPiNilakantha(): Double {
    var pi = 3.0;
    var sign = 1;
    for (i in 2..100000 step 2) {
        pi += sign * 4.0/(i * (i + 1) * (i + 2));
        sign *= -1;
    }

    return pi;
}
