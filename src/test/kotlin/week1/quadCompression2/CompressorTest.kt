package week1.quadCompression2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompressorTest {
    @Test
    fun testCanCompressShouldBeTrueWhenAllTheSameNum() {
        var input = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        var compressor = Compressor.create(input)
        assertTrue(compressor.canCompress(Point(0, 0), input.size))

        input = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )

        compressor = Compressor.create(input)
        assertTrue(compressor.canCompress(Point(0, 0), input.size))

        input = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 0, 1, 1)
        )

        compressor = Compressor.create(input)
        assertTrue(compressor.canCompress(Point(0, 0), input.size / 2))
        assertTrue(compressor.canCompress(Point(2, 0), input.size / 2))
        assertTrue(compressor.canCompress(Point(0, 2), input.size / 2))
        assertTrue(compressor.canCompress(Point(2, 2), input.size / 2))
    }

    @Test
    fun testCanCompressShouldBeFalseWhenNotAllTheSameNum() {
        var input = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 0)
        )

        var compressor = Compressor.create(input)
        assertFalse(compressor.canCompress(Point(0, 0), input.size))

        input = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )

        compressor = Compressor.create(input)
        assertFalse(compressor.canCompress(Point(0, 0), input.size))

        input = arrayOf(
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(0, 0, 1, 1)
        )

        compressor = Compressor.create(input)
        assertFalse(compressor.canCompress(Point(0, 0), input.size / 2))
        assertFalse(compressor.canCompress(Point(2, 0), input.size / 2))
        assertFalse(compressor.canCompress(Point(0, 2), input.size / 2))
        assertFalse(compressor.canCompress(Point(2, 2), input.size / 2))
    }

    @Test
    fun testCompressWhenNumIsZero() {
        var input = arrayOf(
            intArrayOf(0)
        )
        var compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(1, 0))


        input = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(1, 0))


        input = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )
        compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(1, 0))
    }

    @Test
    fun testCompressWhenNumIsOne() {
        var input = arrayOf(
            intArrayOf(1)
        )
        var compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(0, 1))


        input = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(0, 1))


        input = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        compressor = Compressor.create(input)

        assertArrayEquals(compressor.compress(Point(0, 0)), intArrayOf(0, 1))
    }
}