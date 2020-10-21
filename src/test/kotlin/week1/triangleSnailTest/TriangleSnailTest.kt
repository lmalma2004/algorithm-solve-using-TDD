package week1.triangleSnailTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import week1.triangleSnail.TriangleSnail

internal class TriangleSnailTest {
    @Test
    fun testAlgorithm() {
        val triangleSnail = TriangleSnail()

        val case1 = intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7)
        assertArrayEquals(case1, triangleSnail.solution(4))

        val case2 = intArrayOf(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9)
        assertArrayEquals(case2, triangleSnail.solution(5))

        val case3 = intArrayOf(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11)
        assertArrayEquals(case3, triangleSnail.solution(6))

        val case4 = intArrayOf(1)
        assertArrayEquals(case4, triangleSnail.solution(1))
    }

    @Test
    fun testCreateArrayList() {
        val triangleSnail = TriangleSnail()

        val case1 = arrayListOf(
            IntArray(1)
        )
        val emptyArrayList1 = triangleSnail.createArrayList(1)
        assertArrayEquals(case1.toArray(), emptyArrayList1.toArray())

        val case2 = arrayListOf(
            IntArray(1),
            IntArray(2)
        )
        val emptyArrayList2 = triangleSnail.createArrayList(2)
        assertArrayEquals(case2.toArray(), emptyArrayList2.toArray())

        val case3 = arrayListOf(
            IntArray(1),
            IntArray(2),
            IntArray(3)
        )
        val emptyArrayList3 = triangleSnail.createArrayList(3)
        assertArrayEquals(case3.toArray(), emptyArrayList3.toArray())

        val case4 = arrayListOf(
            IntArray(1),
            IntArray(2),
            IntArray(3),
            IntArray(4)
        )
        val emptyArrayList4 = triangleSnail.createArrayList(4)
        assertArrayEquals(case4.toArray(), emptyArrayList4.toArray())
    }

    @Test
    fun testFillNumInArrayList() {
        val triangleSnail = TriangleSnail()

        val case1 = arrayListOf(
            intArrayOf(1),
            intArrayOf(2, 9),
            intArrayOf(3, 10, 8),
            intArrayOf(4, 5, 6, 7)
        )
        val emptyArrayList1 = triangleSnail.createArrayList(4)
        assertArrayEquals(case1.toArray(), triangleSnail.fillNumInArrayList(emptyArrayList1).toArray())

        val case2 = arrayListOf(
            intArrayOf(1),
            intArrayOf(2, 12),
            intArrayOf(3, 13, 11),
            intArrayOf(4, 14, 15, 10),
            intArrayOf(5, 6, 7, 8, 9)
        )
        val emptyArrayList2 = triangleSnail.createArrayList(5)
        assertArrayEquals(case2.toArray(), triangleSnail.fillNumInArrayList(emptyArrayList2).toArray())

        val case3 = arrayListOf(
            intArrayOf(1),
            intArrayOf(2, 15),
            intArrayOf(3, 16, 14),
            intArrayOf(4, 17, 21, 13),
            intArrayOf(5, 18, 19, 20, 12),
            intArrayOf(6, 7, 8, 9, 10, 11)
        )
        val emptyArrayList3 = triangleSnail.createArrayList(6)
        assertArrayEquals(case3.toArray(), triangleSnail.fillNumInArrayList(emptyArrayList3).toArray())
    }

    @Test
    fun testGetResult() {
        val triangleSnail = TriangleSnail()

        val case1 = intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7)
        val emptyArrayList1 = triangleSnail.createArrayList(4)
        val fillArrayList1 = triangleSnail.fillNumInArrayList(emptyArrayList1)
        assertArrayEquals(case1, triangleSnail.getResult(fillArrayList1))

        val case2 = intArrayOf(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9)
        val emptyArrayList2 = triangleSnail.createArrayList(5)
        val fillArrayList2 = triangleSnail.fillNumInArrayList(emptyArrayList2)
        assertArrayEquals(case2, triangleSnail.getResult(fillArrayList2))

        val case3 = intArrayOf(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11)
        val emptyArrayList3 = triangleSnail.createArrayList(6)
        val fillArrayList3 = triangleSnail.fillNumInArrayList(emptyArrayList3)
        assertArrayEquals(case3, triangleSnail.getResult(fillArrayList3))
    }
}