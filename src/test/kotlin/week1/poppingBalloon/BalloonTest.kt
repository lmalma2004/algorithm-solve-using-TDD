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
}