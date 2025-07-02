package com.gitTraining

import kotlin.math.absoluteValue
import kotlin.math.sign

fun computeFibbonaciNumber(position: Int?, recursion: Boolean = false): Int {
    val position = position ?: 1

    if (position == 0) return 0

    if (recursion) {
        return when (position.absoluteValue) {
            1 -> 1
            2 -> position.sign
            else -> recursiveFibbonachi(
                previous = 1,
                current = position.sign,
                stepsLeft = position - 2 * position.sign
            )
        }
    }

    return when (position) {
        in Int.MIN_VALUE..<0 -> computeNegativeFibbonachi(position)
        1, 2 -> 1
        else -> {
            var smallFibbonachiNumber = 1
            var largeFibbonachiNumber = 1

            var currentPosition = 2
            while (currentPosition < position) {
                val nextFibbonachiNumber = smallFibbonachiNumber + largeFibbonachiNumber
                smallFibbonachiNumber = largeFibbonachiNumber
                largeFibbonachiNumber = nextFibbonachiNumber
                currentPosition ++
            }

            largeFibbonachiNumber
        }
    }
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

fun recursiveFibbonachi(previous: Int, current: Int, stepsLeft: Int): Int {
    return when (stepsLeft) {
        0 -> current
        else -> {
            val newCurrent = previous + current * stepsLeft.sign
            recursiveFibbonachi(current, newCurrent, stepsLeft - stepsLeft.sign)
        }
    }
}
