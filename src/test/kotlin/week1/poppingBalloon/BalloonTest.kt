package week1.poppingBalloon

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BalloonTest {

    @Test
    fun `balloon number should be between -1,000,000,000 and 1,000,000,000`() {
        assertThrows<IllegalArgumentException> {
            Balloon.create(-1000000001)
        }

        assertThrows<IllegalArgumentException> {
            Balloon.create(1000000001)
        }
    }
}