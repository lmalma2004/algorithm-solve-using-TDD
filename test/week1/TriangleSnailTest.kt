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
        val emptyArrayList1 = triangleSnail.createArrayList(1)
        assert(isEqualSize(arrayListOfSize1, emptyArrayList1))

        val arrayListOfSize2 = arrayListOf(
                IntArray(1),
                IntArray(2)
        )
        val emptyArrayList2 = triangleSnail.createArrayList(2)
        assert(isEqualSize(arrayListOfSize2, emptyArrayList2))

        val arrayListOfSize3 = arrayListOf(
                IntArray(1),
                IntArray(2),
                IntArray(3)
        )
        val emptyArrayList3 = triangleSnail.createArrayList(3)
        assert(isEqualSize(arrayListOfSize3, emptyArrayList3))

        val arrayListOfSize4 = arrayListOf(
                IntArray(1),
                IntArray(2),
                IntArray(3),
                IntArray(4)
        )
        val emptyArrayList4 = triangleSnail.createArrayList(4)
        assert(isEqualSize(arrayListOfSize4, emptyArrayList4))
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
        val emptyArrayList1 = triangleSnail.createArrayList(4)
        assertEquals(case1, triangleSnail.fillArrayList(emptyArrayList1))

        val case2 = arrayListOf(
                intArrayOf(1),
                intArrayOf(2, 12),
                intArrayOf(3, 13, 11),
                intArrayOf(4, 14, 15, 10),
                intArrayOf(5, 6, 7, 8, 9)
        )
        val emptyArrayList2 = triangleSnail.createArrayList(4)
        assertEquals(case2, triangleSnail.fillArrayList(emptyArrayList2))

        val case3 = arrayListOf(
                intArrayOf(1),
                intArrayOf(2, 15),
                intArrayOf(3, 16, 14),
                intArrayOf(4, 17, 21, 13),
                intArrayOf(5, 18, 19, 20, 12),
                intArrayOf(5, 6, 7, 8, 9, 10, 11)
        )
        val emptyArrayList3 = triangleSnail.createArrayList(4)
        assertEquals(case3, triangleSnail.fillArrayList(emptyArrayList3))
    }

    @Test
    fun testGetResult() {
        val triangleSnail = TriangleSnail()

        val case1 = intArrayOf(1, 2, 9, 3, 10, 8, 4, 5, 6, 7)
        val emptyArrayList1 = triangleSnail.createArrayList(4)
        val fillArrayList1 = triangleSnail.fillArrayList(emptyArrayList1)
        assertEquals(case1, triangleSnail.getResult(fillArrayList1))

        val case2 = intArrayOf(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9)
        val emptyArrayList2 = triangleSnail.createArrayList(5)
        val fillArrayList2 = triangleSnail.fillArrayList(emptyArrayList2)
        assertEquals(case2, triangleSnail.getResult(fillArrayList2))

        val case3 = intArrayOf(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11)
        val emptyArrayList3 = triangleSnail.createArrayList(6)
        val fillArrayList3 = triangleSnail.fillArrayList(emptyArrayList3)
        assertEquals(case3, triangleSnail.getResult(fillArrayList3))
    }

    private fun isEqualSize(arrayList1: ArrayList<IntArray>, arrayList2: ArrayList<IntArray>): Boolean {
        if (arrayList1.size != arrayList2.size)
            return false

        for (i in 0 until arrayList1.size) {
            if (arrayList1[i].size != arrayList2[i].size)
                return false
        }

        return true
    }
}