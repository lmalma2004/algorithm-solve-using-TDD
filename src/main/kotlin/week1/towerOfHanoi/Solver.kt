package week1.towerOfHanoi

import java.util.*

class Solver(val towers: Array<Tower>) {
    fun execute(): Array<IntArray> {
        val states: Queue<State> = LinkedList(listOf())
        val startState = State.of(towers)

        states.add(startState)

        while (!states.isEmpty()) {
            val state = states.peek()

            if (state.isFinish()) {
                return state.path()
            }

            val mover = Mover.create()

            for (tower in towers.indices) {
                if (!mover.canMove(state, tower)) {
                    continue
                }

                mover.nextTowers(state).forEach {
                    val nextState = mover.move(state, tower, it)
                    states.add(nextState)
                }
            }
        }

        throw IllegalStateException()
    }

    companion object {
        fun of(towers: Array<Tower>): Solver {
            return Solver(towers)
        }
    }

}
