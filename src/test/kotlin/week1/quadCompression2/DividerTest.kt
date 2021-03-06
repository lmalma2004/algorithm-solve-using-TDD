package week1.quadCompression2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DividerTest {
    @Test
    fun testDivide_Should_Be_Return_4Points() {
        val divider = Divider()
        assertEquals(4, divider.divide(Point(0, 0), 2).size)
        assertEquals(4, divider.divide(Point(0, 2), 2).size)
        assertEquals(4, divider.divide(Point(2, 0), 2).size)
    }

    @Test
    fun testFirstAreaPoint_Should_Be_Equal_StartPoint() {
        val divider = Divider()

        var areas = divider.divide(Point(0, 0), 4)
        assertEquals(areas[0], Point(0, 0))

        areas = divider.divide(Point(2, 2), 4)
        assertEquals(areas[0], Point(2, 2))

        areas = divider.divide(Point(4, 0), 4)
        assertEquals(areas[0], Point(4, 0))
    }

    @Test
    fun testSecondAreaPoint_Should_Be_Row_And_ColPlusHalfSize() {
        val divider = Divider()

        var areas = divider.divide(Point(0, 0), 4)
        assertEquals(areas[1], Point(0, 0 + 4 / 2))

        areas = divider.divide(Point(2, 2), 4)
        assertEquals(areas[1], Point(2, 2 + 4 / 2))

        areas = divider.divide(Point(4, 0), 4)
        assertEquals(areas[1], Point(4, 0 + 4 / 2))
    }

    @Test
    fun testThirdAreaPoint_Should_Be_RowPlusHalfSize_And_Col() {
        val divider = Divider()

        var areas = divider.divide(Point(0, 0), 4)
        assertEquals(areas[2], Point(0 + 4 / 2, 0))

        areas = divider.divide(Point(2, 2), 4)
        assertEquals(areas[2], Point(2 + 4 / 2, 2))

        areas = divider.divide(Point(4, 0), 4)
        assertEquals(areas[2], Point(4 + 4 / 2, 0))
    }

    @Test
    fun testFourthAreaPoint_Should_Be_RowPlusHalfSize_And_ColPlusHalfSize() {
        val divider = Divider()

        var areas = divider.divide(Point(0, 0), 4)
        assertEquals(areas[3], Point(0 + 4 / 2, 0 + 4 / 2))

        areas = divider.divide(Point(2, 2), 4)
        assertEquals(areas[3], Point(2 + 4 / 2, 2 + 4 / 2))

        areas = divider.divide(Point(4, 0), 4)
        assertEquals(areas[3], Point(4 + 4 / 2, 0 + 4 / 2))
    }

    @Test
    fun testNextSizeShouldBeReturnHalf() {
        val divider = Divider()
        assertEquals(divider.nextSize(2), 1)
        assertEquals(divider.nextSize(4), 2)
        assertEquals(divider.nextSize(8), 4)
    }
}