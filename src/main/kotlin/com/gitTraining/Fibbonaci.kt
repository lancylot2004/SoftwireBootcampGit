package com.gitTraining

fun computeFibbonaciNumber(position: Int): Int {
    var i = 1
    var j = 1

    if (position <= 2) return 1

    var currentPosition = 2
    while (currentPosition < position) {
        val temp = i
        i = j
        j += temp
        currentPosition++
    }
    return j
}
