package week1.towerOfHanoi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TowerTest {

    @Test
    fun `tower size must not be less than 0`() {
        assertThrows<IllegalArgumentException> { Tower.create(-1) }
        assertThrows<IllegalArgumentException> { Tower.create(-2) }
        assertDoesNotThrow { Tower.create(0) }
        assertDoesNotThrow { Tower.create(1) }
    }
}