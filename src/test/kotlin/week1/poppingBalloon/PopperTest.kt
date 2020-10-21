package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PopperTest {

    @Test
    fun `test execute() should be return 3`() {
        val balloon = Balloon.create(intArrayOf(9, -1, -5))
        val popper = Popper.of(balloon)
        assertEquals(3, popper.execute())
    }

    @Test
    fun `test execute() should be return 4`() {
        val balloon = Balloon.create(intArrayOf(5, 2, -4, -2, -6))
        val popper = Popper.of(balloon)
        assertEquals(4, popper.execute())
    }

    @Test
    fun `test execute() should be return 5`() {
        val balloon = Balloon.create(intArrayOf(8, -4, 2, 5, 1, 10, 26))
        val popper = Popper.of(balloon)
        assertEquals(5, popper.execute())
    }

    @Test
    fun `test execute() should be return 6`() {
        val balloon = Balloon.create(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33))
        val popper = Popper.of(balloon)
        assertEquals(6, popper.execute())
    }
}