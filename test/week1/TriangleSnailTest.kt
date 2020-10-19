package week1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TriangleSnailTest {
    @Test
    fun testAlgorithm() {
        val triangleSnail = TriangleSnail()

        val case1 = intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7)
        assertEquals(case1, triangleSnail.solution(4))

        val case2 = intArrayOf(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9)
        assertEquals(case2, triangleSnail.solution(5))

        val case3 = intArrayOf(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11)
        assertEquals(case3, triangleSnail.solution(6))
    }

    @Test
    fun testCreateArrayList() {
        val triangleSnail = TriangleSnail()

        val arrayListOfSize1 = arrayListOf(
                IntArray(1)
        )
        assertEquals(arrayListOfSize1, triangleSnail.createArrayList(1))

        val arrayListOfSize2 = arrayListOf(
                IntArray(1),
                IntArray(2)
        )
        assertEquals(arrayListOfSize2, triangleSnail.createArrayList(2))

        val arrayListOfSize3 = arrayListOf(
                IntArray(1),
                IntArray(2),
                IntArray(3)
        )
        assertEquals(arrayListOfSize3, triangleSnail.createArrayList(3))

        val arrayListOfSize4 = arrayListOf(
                IntArray(1),
                IntArray(2),
                IntArray(3),
                IntArray(4)
        )
        assertEquals(arrayListOfSize4, triangleSnail.createArrayList(4))
    }

    @Test
    fun testFillArrayList() {
        val triangleSnail = TriangleSnail()

        val case1 = arrayListOf(
                intArrayOf(1),
                intArrayOf(2, 9),
                intArrayOf(3, 10, 8),
                intArrayOf(4, 5, 6, 7)
        )

        val emptyArrayList = triangleSnail.createArrayList(4)
        assertEquals(case1, triangleSnail.fillArrayList(emptyArrayList))
    }

    @Test
    fun testGetResult() {
        val triangleSnail = TriangleSnail()

        val case1 = intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7)

        val emptyArrayList = triangleSnail.createArrayList(4)
        val fillArrayList = triangleSnail.fillArrayList(emptyArrayList)
        assertEquals(case1, triangleSnail.getResult(fillArrayList))
    }
}