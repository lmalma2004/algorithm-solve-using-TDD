package week1.towerOfHanoi

class Mover {
    companion object {
        fun create(): Mover {
            return Mover()
        }
    }

    fun canMove(state: State, tower: Int): Boolean {
        TODO("Not yet implemented")
    }

    fun nextTowers(state: State): IntArray {
        TODO("Not yet implemented")
    }

    fun move(state: State, from: Int, to: Int): State {
        TODO("Not yet implemented")
    }
}
