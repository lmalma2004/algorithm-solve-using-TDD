package week1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QuadCompressionTest {
    @Test
    fun testAlgorithm() {
        val quadCompression = QuadCompression()

        val input1 = arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 0, 0, 1),
                intArrayOf(1, 1, 1, 1)
        )
        val output1 = intArrayOf(4, 9)
        assertArrayEquals(output1, quadCompression.solution(input1))

        val input2 = arrayOf(
                intArrayOf(1,1,1,1,1,1,1,1),
                intArrayOf(0,1,1,1,1,1,1,1),
                intArrayOf(0,0,0,0,1,1,1,1),
                intArrayOf(0,1,0,0,1,1,1,1),
                intArrayOf(0,0,0,0,0,0,1,1),
                intArrayOf(0,0,0,0,0,0,0,1),
                intArrayOf(0,0,0,0,1,0,0,1),
                intArrayOf(0,0,0,0,1,1,1,1)
        )
        val output2 = intArrayOf(10, 15)
        assertArrayEquals(output2, quadCompression.solution(input2))
    }

    @Test
    fun testCheckArea() {
        val quadCompression = QuadCompression()

        val case1 = arrayOf(
                intArrayOf(0)
        )
        assert(quadCompression.checkArea(case1))

        val case2 = arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 0)
        )
        assert(quadCompression.checkArea(case2))

        val case3 = arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
        )
        assertFalse(quadCompression.checkArea(case3))

        val case4 = arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1)
        )
        assert(quadCompression.checkArea(case4))


    }

    @Test
    fun testCompressArea() {
        val quadCompression = QuadCompression()

        val case1 = arrayOf(
                intArrayOf(0)
        )
        assertEquals(0, quadCompression.compressArea(case1))

        val case2 = arrayOf(
                intArrayOf(1)
        )
        assertEquals(1, quadCompression.compressArea(case2))

        val case3 = arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 0)
        )
        assertEquals(0, quadCompression.compressArea(case3))

        val case4 = arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1)
        )
        assertEquals(1, quadCompression.compressArea(case4))
    }
}