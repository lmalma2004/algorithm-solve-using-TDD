package week1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QuadCompressionTest {
    @Test
    fun testAlgorithm() {
        val quadCompression = QuadCompression()

        var input1 = arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 0, 0, 1),
                intArrayOf(1, 1, 1, 1)
        )
        var output1 = intArrayOf(4, 9)
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

    @Test
    fun testDivideArea() {
        val quadCompression = QuadCompression()

        var size = 2

        val loc1 = Pair(0, 0)
        val case1 = arrayOf(
                Pair(0, 0),
                Pair(0, 1),
                Pair(1, 0),
                Pair(1, 1)
        )
        assertArrayEquals(case1, quadCompression.divideArea(loc1, size))

        val loc2 = Pair(0, 2)
        val case2 = arrayOf(
                Pair(0, 2),
                Pair(0, 3),
                Pair(1, 2),
                Pair(1, 3)
        )
        assertArrayEquals(case2, quadCompression.divideArea(loc2, size))

        val loc3 = Pair(2, 0)
        val case3 = arrayOf(
                Pair(2, 0),
                Pair(2, 1),
                Pair(3, 0),
                Pair(3, 1)
        )
        assertArrayEquals(case3, quadCompression.divideArea(loc3, size))

        val loc4 = Pair(2, 2)
        val case4 = arrayOf(
                Pair(2, 2),
                Pair(2, 3),
                Pair(3, 2),
                Pair(3, 3)
        )
        assertArrayEquals(case4, quadCompression.divideArea(loc4, size))
    }
}