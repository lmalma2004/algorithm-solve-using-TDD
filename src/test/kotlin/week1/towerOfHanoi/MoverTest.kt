package week1.towerOfHanoi

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MoverTest {

    @Test
    fun `if there is a disk larger than the current disk in another tower, it can be moved`() {
        var state = State.of(arrayOf(
                Tower.create(3),
                Tower.create(0),
                Tower.create(0))
        )
        var mover = Mover.create()
        assertTrue(mover.canMove(state, 0))

        state = mover.move(state,0, 1)
        assertTrue(mover.canMove(state,1))
    }

    @Test
    fun `if there is not a disk larger than the current disk in another tower, it can't be moved`() {
        var state = State.of(arrayOf(
                Tower.create(3),
                Tower.create(0),
                Tower.create(0))
        )
        val mover = Mover.create()

        state = mover.move(state,0, 1)
        state = mover.move(state,0, 2)

        assertFalse(mover.canMove(state, 0))
    }

    @Test
    fun `should return towers that can move the disc`() {
        var state = State.of(arrayOf(
                Tower.create(3),
                Tower.create(0),
                Tower.create(0))
        )
        val mover = Mover.create()
        assertArrayEquals(intArrayOf(1, 2), mover.nextTowers(state, 0))

        state = mover.move(state,0, 1)
        assertArrayEquals(intArrayOf(2), mover.nextTowers(state, 0))

        state = mover.move(state,0, 2)
        assertArrayEquals(intArrayOf(0, 2), mover.nextTowers(state, 1))
    }

    @Test
    fun `if you move the disc, it will be on top of the tower`() {
        var state = State.of(arrayOf(
                Tower.create(3),
                Tower.create(0),
                Tower.create(0))
        )
        val mover = Mover.create()

        state = mover.move(state,0, 1)
        assertEquals(1, state.towers[1].discs.peek())

        state = mover.move(state,0, 2)
        assertEquals(2, state.towers[2].discs.peek())
    }
}