package week1.poppingBalloon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BalloonCheckerTest {
    private val poppingBalloon = PoppingBalloon()

    @Test
    fun `the leftMin of the idx balloon is the minimum value of the begin ~ idx-1 balloons`() {
        val result = intArrayOf(0, -16, -16, -16, -16, -16, -92, -92, -92, -92, -92)

        val balloons = poppingBalloon.createBalloons(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33))
        val balloonChecker = BalloonChecker()
        val checkedBalloons = balloonChecker.check(balloons)

        assertArrayEquals(result, checkedBalloons.map { it.leftMin }.toIntArray())
    }

    @Test
    fun `the rightMin of the idx balloon is the minimum value of the idx+1 ~ end-1 balloons`() {
        val result = intArrayOf(-92, -92, -92, -92, -92, -71, -68, -61, -33, 0)

        val balloons = poppingBalloon.createBalloons(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33))
        val balloonChecker = BalloonChecker()
        val checkedBalloons = balloonChecker.check(balloons)

        assertArrayEquals(result, checkedBalloons.map { it.rightMin }.toIntArray())
    }

    @Test
    fun `if idx balloon is greater than both leftMin and rightMin, no counting`() {
        val result = 0

        val balloons = arrayOf(
            Balloon(4, 3, 2),
            Balloon(5, 1, -2),
            Balloon(1, 0, -9)
        )
        val balloonChecker = BalloonChecker()
        val checkedBalloons = balloonChecker.check(balloons)

        assertEquals(result, balloonChecker.count(checkedBalloons))
    }

    @Test
    fun `if the idx balloon is not greater than both leftMin and rightMin, count`() {
        val result = 3

        val balloons = arrayOf(
            Balloon(4, 5, 3),
            Balloon(4, 3, 5),
            Balloon(5, 6, 7)
        )
        val balloonChecker = BalloonChecker()
        val checkedBalloons = balloonChecker.check(balloons)

        assertEquals(result, balloonChecker.count(checkedBalloons))
    }
}