package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PopperTest {
    private val poppingBalloon = PoppingBalloon()

    @Test
    fun `test execute() should be return 3`() {
        val balloons = poppingBalloon.createBalloons(intArrayOf(9, -1, -5))
        val popper = Popper.of(balloons)
        assertEquals(3, popper.execute())
    }

    @Test
    fun `test execute() should be return 4`() {
        val balloons = poppingBalloon.createBalloons(intArrayOf(5, 2, -4, -2, -6))
        val popper = Popper.of(balloons)
        assertEquals(4, popper.execute())
    }

    @Test
    fun `test execute() should be return 5`() {
        val balloons = poppingBalloon.createBalloons(intArrayOf(8, -4, 2, 5, 1, 10, 26))
        val popper = Popper.of(balloons)
        assertEquals(5, popper.execute())
    }

    @Test
    fun `test execute() should be return 6`() {
        val balloons = poppingBalloon.createBalloons(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33))
        val popper = Popper.of(balloons)
        assertEquals(6, popper.execute())
    }
}