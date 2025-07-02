package com.gitTraining

fun computeFibbonaciNumber(position: Int): Int {
    if (position == 0) return 0
    if (position < 0) {
        return computeNegativeFibbonachi(position)
    }

    if (position == 1 || position == 2) return 1

    var smallFibbonachiNumber = 1
    var largeFibbonachiNumber = 1

    var currentPosition = 2
    while (currentPosition < position) {
        val nextFibbonachiNumber = smallFibbonachiNumber + largeFibbonachiNumber
        smallFibbonachiNumber = largeFibbonachiNumber
        largeFibbonachiNumber = nextFibbonachiNumber
        currentPosition ++
    }
    return largeFibbonachiNumber
}

fun computeFibbonachiArray(start: Int, end: Int, efficient: Boolean = false): List<Int> {
    if (!efficient) return (start..end).map { computeFibbonaciNumber(it) }
    if (start > end) return listOf()
    if (start == end) return listOf(computeFibbonaciNumber(start))
    val output = mutableListOf(computeFibbonaciNumber(start), computeFibbonaciNumber(start + 1))
    (2..(end-start)).forEach { output.add(output[it-2] + output[it-1]) }
    return output
}

fun computeNegativeFibbonachi(position:Int): Int {
    if (position >= 0) throw Exception("potition must be smaller than zero!")
    val resultIsNegative = position % 2 == 0
    val absoluteResult = computeFibbonaciNumber(-position)
    return if (resultIsNegative) (absoluteResult * -1) else absoluteResult
}
