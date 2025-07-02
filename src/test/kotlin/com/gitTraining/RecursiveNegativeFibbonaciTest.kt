package com.gitTraining

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class RecursiveNegativeFibbonaciTest {
    @Test
    fun recursive_fibbonaci_works_for_small_numbers() {
        val inputs = listOf(-6,-5,-4,-3,-2,-1,0)
        val expectedOutputs = listOf(-8,5,-3,2,-1,1,0)

        for ((input, expectedOutput) in inputs.zip(expectedOutputs)) {
            assertThat(computeFibbonaciNumber(input, true)).isEqualTo(expectedOutput)
        }
    }
}
