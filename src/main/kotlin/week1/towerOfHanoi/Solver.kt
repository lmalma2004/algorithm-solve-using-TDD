package week1.towerOfHanoi

import java.util.*

class Solver(val towers: Array<Tower>) {
    fun execute(): Array<IntArray> {
        val states: Queue<State> = LinkedList(listOf())
        val startState = State.of(towers)

        states.add(startState)

        while (!states.isEmpty()) {
            val state = states.poll()

            if (state.isFinish()) {
                return state.path()
            }

            val mover = Mover.create()

            for (tower in state.towers.indices) {
                if (!mover.canMove(state, tower)) {
                    continue
                }

                mover.nextTowers(state, tower).forEach {
                    val nextState = mover.move(state.clone(), tower, it)
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
