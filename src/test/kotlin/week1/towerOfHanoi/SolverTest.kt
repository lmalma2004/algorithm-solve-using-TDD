package week1.towerOfHanoi

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolverTest {

    @Test
    fun `when the number of discs is 3`() {
        val result = listOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
        )

        val towers = arrayOf(
                Tower(3),
                Tower(0),
                Tower(0)
        )
        val solver = Solver.of(towers)

        assertEquals(result, solver.execute())
    }

    @Test
    fun `when the number of discs is 4`() {
        val result = listOf(
                intArrayOf(1, 3),
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 3)
        )

        val towers = arrayOf(
                Tower(4),
                Tower(0),
                Tower(0)
        )
        val solver = Solver.of(towers)

        assertEquals(result, solver.execute())
    }
}