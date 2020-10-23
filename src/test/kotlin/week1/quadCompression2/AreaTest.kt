package week1.quadCompression2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class AreaTest {
    @Test
    fun testCreateAreaSizeShouldBePowerOf2() {
        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    IntArray(1)
                )
            )
        }

        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    IntArray(2),
                    IntArray(2)
                )
            )
        }

        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    IntArray(4),
                    IntArray(4),
                    IntArray(4),
                    IntArray(4)
                )
            )
        }
    }

    @Test
    fun testCreateAreaShouldBeSquare() {
        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    intArrayOf(1)
                )
            )
        }

        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                )
            )
        }

        assertDoesNotThrow {
            Area.create(
                arrayOf(
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(0, 0, 1, 1)
                )
            )
        }
    }

    @Test
    fun testCreateAreaWhenInvalidSize() {
        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    IntArray(3),
                    IntArray(3),
                    IntArray(3)
                )
            )
        }

        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    IntArray(5),
                    IntArray(5),
                    IntArray(5),
                    IntArray(5),
                    IntArray(5)
                )
            )
        }

        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    IntArray(6),
                    IntArray(6),
                    IntArray(6),
                    IntArray(6),
                    IntArray(6),
                    IntArray(6)
                )
            )
        }
    }

    @Test
    fun testCreateAreaWhenNotSquare() {
        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    intArrayOf(0, 0)
                )
            )
        }

        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    intArrayOf(0),
                    intArrayOf(0, 0)
                )
            )
        }

        assertThrows<IllegalArgumentException> {
            Area.create(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0)
                )
            )
        }
    }

    @Test
    fun testQuadCompressShouldBeCalledOnlyOnce() {
        // 어떻게 하지?
    }

    @Test
    fun testQuadCompressShouldBeCalledOnlyTwice() {
        // 어떻게 하지?
    }

    @Test
    fun testQuadCompressShouldBeCalledAtLeastThreeTime() {
        // 어떻게 하지?
    }
}