package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PoppingBalloonTest {

    @Test
    fun `test case #1`() {
        val input = intArrayOf(9, -1, -5)
        val output = 3

        assertEquals(output, PoppingBalloon().solution(input))
    }

    @Test
    fun `test case #2`() {
        val input = intArrayOf(-16,27,65,-2,58,-92,-71,-68,-61,-33)
        val output = 6

        assertEquals(output, PoppingBalloon().solution(input))
    }
}