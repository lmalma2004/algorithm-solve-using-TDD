package week1.towerOfHanoi

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolverTest {

    @Test
    fun `when the number of discs is 2`() {
        val result = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
        )

        val towers = arrayOf(
                Tower.create(2),
                Tower.create(0),
                Tower.create(0)
        )
        val solver = Solver.of(towers)

        assertArrayEquals(result, solver.execute())
    }

    @Test
    fun `when the number of discs is 3`() {
        val result = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 3)
        )

        val towers = arrayOf(
                Tower.create(3),
                Tower.create(0),
                Tower.create(0)
        )
        val solver = Solver.of(towers)

        assertArrayEquals(result, solver.execute())
    }
}