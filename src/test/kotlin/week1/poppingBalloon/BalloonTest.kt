package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class BalloonTest {

    @Test
    fun `create() array size should be between 1 and 1,000,000`() {
        assertThrows<IllegalArgumentException> {
            Balloon.create(
                IntArray(1000001)
            )
        }

        assertThrows<IllegalArgumentException> {
            Balloon.create(
                IntArray(0)
            )
        }
    }

    @Test
    fun `all numbers in array are integers from -1,000,000,000 to 1,000,000,000`() {
        assertThrows<IllegalArgumentException> {
            Balloon.create(
                intArrayOf(-1000000001)
            )
        }

        assertThrows<IllegalArgumentException> {
            Balloon.create(
                intArrayOf(1000000001)
            )
        }
    }

    @Test
    fun `every number in array is different`() {
        assertThrows<IllegalArgumentException> {
            Balloon.create(
                intArrayOf(0, 0)
            )
        }

        assertThrows<IllegalArgumentException> {
            Balloon.create(
                intArrayOf(1, 1)
            )
        }
    }

    @Test
    fun `test pop() when return 3`() {
        val balloon = Balloon.create(intArrayOf(9, -1, -5))
        assertEquals(3, balloon.pop())
    }

    @Test
    fun `test pop() when return 4`() {
        val balloon = Balloon.create(intArrayOf(5, 2, -4, -2, -6))
        assertEquals(4, balloon.pop())
    }

    @Test
    fun `test pop() when return 5`() {
        val balloon = Balloon.create(intArrayOf(8, -4, 2, 5, 1, 10, 26))
        assertEquals(5, balloon.pop())
    }

    @Test
    fun `test pop() when return 6`() {
        val balloon = Balloon.create(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33))
        assertEquals(6, balloon.pop())
    }
}