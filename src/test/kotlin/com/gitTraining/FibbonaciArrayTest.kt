package com.gitTraining

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class FibbonaciArrayTest {
    @Test
    fun fibbonaci_array_works_for_small_range() {
        val inputs = (-10..10)
        val expectedOutputs = inputs.map { computeFibbonaciNumber(it) }
        val outputs = computeFibbonachiArray(-10, 10)
        for ((output, expectedOutput) in outputs.zip(expectedOutputs)) {
            assertThat(output).isEqualTo(expectedOutput)
        }
    }
}
