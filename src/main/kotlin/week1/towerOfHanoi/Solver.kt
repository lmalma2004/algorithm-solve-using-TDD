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

            val mover = Mover.create(state)

            for (tower in towers.indices) {
                if (tower == state.lastPlaced()) {
                    continue
                }

                if (!mover.canMove(tower)) {
                    continue
                }

                mover.nextTowers().forEach {
                    val nextState = mover.moveTo(it)
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
