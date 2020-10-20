package week1.quadCompression2Test

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import week1.quadCompression2.QuadCompression2

internal class QuadCompression2Test {
    @Test
    fun testSolutionCase1() {
        val input = arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 0, 0, 1),
                intArrayOf(1, 1, 1, 1)
        )
        val output = intArrayOf(4, 9)
        val quadCompression2 = QuadCompression2()
        assertArrayEquals(quadCompression2.solution(input), output)
    }

    @Test
    fun testSolutionCase2() {
        val input = arrayOf(
                intArrayOf(1,1,1,1,1,1,1,1),
                intArrayOf(0,1,1,1,1,1,1,1),
                intArrayOf(0,0,0,0,1,1,1,1),
                intArrayOf(0,1,0,0,1,1,1,1),
                intArrayOf(0,0,0,0,0,0,1,1),
                intArrayOf(0,0,0,0,0,0,0,1),
                intArrayOf(0,0,0,0,1,0,0,1),
                intArrayOf(0,0,0,0,1,1,1,1)
        )
        val output = intArrayOf(10, 15)
        val quadCompression2 = QuadCompression2()
        assertArrayEquals(quadCompression2.solution(input), output)
    }
}