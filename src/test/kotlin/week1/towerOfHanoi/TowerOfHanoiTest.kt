package week1.towerOfHanoi

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TowerOfHanoiTest {

    @Test
    fun `test case #1`() {
        val towerOfHanoi = TowerOfHanoi()

        val result = listOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
        )
        assertEquals(result, towerOfHanoi.solution(2))
    }

    @Test
    fun `test case #2`() {
        val towerOfHanoi = TowerOfHanoi()

        val result = listOf(
                intArrayOf(1, 3),
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 3)
        )
        assertEquals(result, towerOfHanoi.solution(2))
    }
}