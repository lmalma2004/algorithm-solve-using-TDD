package week1.towerOfHanoi

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class StateTest {

    @Test
    fun `towers must be size 3`() {
        assertThrows<IllegalArgumentException> {
            State.of(arrayOf(
                    Tower.create(0))
            )
        }

        assertThrows<IllegalArgumentException> {
            State.of(arrayOf(
                    Tower.create(0),
                    Tower.create(0))
            )
        }

        assertDoesNotThrow { State.of(arrayOf(
                Tower.create(0),
                Tower.create(0),
                Tower.create(0)
        )) }
    }

    @Test
    fun `if there is nothing in the first and second towers, they are all moved`() {
        var state = State.of(
                arrayOf(Tower.create(0),
                        Tower.create(0),
                        Tower.create(0))
        )
        assertTrue(state.isFinish())

        state = State.of(
                arrayOf(Tower.create(0),
                        Tower.create(0),
                        Tower.create(1))
        )
        assertTrue(state.isFinish())

        state = State.of(
                arrayOf(Tower.create(0),
                        Tower.create(0),
                        Tower.create(2))
        )
        assertTrue(state.isFinish())
    }

    @Test
    fun `if the original disk remains in the first and second towers, it has not been moved`() {
        var state = State.of(
                arrayOf(Tower.create(1),
                        Tower.create(0),
                        Tower.create(0))
        )
        assertFalse(state.isFinish())

        state = State.of(
                arrayOf(Tower.create(0),
                        Tower.create(1),
                        Tower.create(1))
        )
        assertFalse(state.isFinish())

        state = State.of(
                arrayOf(Tower.create(1),
                        Tower.create(1),
                        Tower.create(2))
        )
        assertFalse(state.isFinish())
    }

    @Test
    fun `when the disc is moved, it is recorded in the path`() {
        var state = State.of(
                arrayOf(Tower.create(1),
                        Tower.create(0),
                        Tower.create(0))
        )
        var mover = Mover.create()

        state = mover.move(state,0, 1)
        assertArrayEquals(
                arrayOf(intArrayOf(0, 1)), state.path())

        state = mover.move(state,1, 2)
        assertArrayEquals(
                arrayOf(intArrayOf(0, 1),
                        intArrayOf(1, 2)), state.path())

        state = mover.move(state,2, 1)
        assertArrayEquals(
                arrayOf(intArrayOf(0, 1),
                        intArrayOf(1, 2),
                        intArrayOf(2, 1)), state.path())
    }
}