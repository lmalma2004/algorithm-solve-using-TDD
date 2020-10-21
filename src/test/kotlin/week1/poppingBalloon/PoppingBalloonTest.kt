package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `createBalloons() should be array size should be between 1 and 1,000,000`() {
        val poppingBalloon = PoppingBalloon()

        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(IntArray(1000001)) }
        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(IntArray(0))}
    }

    @Test
    fun `createBalloons() should be all numbers in array are integers from -1,000,000,000 to 1,000,000,000`() {
        val poppingBalloon = PoppingBalloon()

        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(intArrayOf(-1000000001)) }
        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(intArrayOf(1000000001))}
    }

    @Test
    fun `createBalloons() should be every number in array is different`() {
        val poppingBalloon = PoppingBalloon()

        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(intArrayOf(0, 0)) }
        assertThrows<IllegalArgumentException> { poppingBalloon.createBalloons(intArrayOf(1, 1))}
    }
}