package com.gitTraining

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class FibbonaciNegativeSeparateTest {
    @Test
    fun negative_fibbonaci_works_for_small_negative_numbers() {
        val inputs = listOf(-6,-5,-4,-3,-2,-1)
        val expectedOutputs = listOf(-8,5,-3,2,-1,1)

        for ((input, expectedOutput) in inputs.zip(expectedOutputs)) {
            assertThat(computeNegativeFibbonachi(input)).isEqualTo(expectedOutput)
        }
    }

    @Test
    fun fibbonaci_throws_for_small_positive_numbers() {
        val inputs = listOf(0,1,2,3)
        for (input in inputs) {
            try {
                computeNegativeFibbonachi(input)
                assertThat(false).isEqualTo(true)
            } catch (e: Exception) {
                //pass
            }
        }
    }
}
