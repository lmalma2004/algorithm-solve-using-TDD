package week1.towerOfHanoi

class Mover {
    companion object {
        fun create(): Mover {
            return Mover()
        }
    }

    fun canMove(state: State, tower: Int): Boolean {
        for(i in state.towers.indices) {
            if (i == tower) {
                continue
            }

            if(state.towers[i].discs.empty()) {
                return true
            }

            val movingDiskSize = state.towers[tower].discs.peek()
            val targetDiskSize = state.towers[i].discs.peek()
            if (movingDiskSize < targetDiskSize) {
                return true
            }
        }

        return false
    }

    fun nextTowers(state: State, tower: Int): IntArray {
        val result = arrayListOf<Int>()

        for(i in state.towers.indices) {
            if (i == tower) {
                continue
            }

            if(state.towers[i].discs.empty()) {
                result.add(i)
                continue
            }

            val movingDiskSize = state.towers[tower].discs.peek()
            val targetDiskSize = state.towers[i].discs.peek()
            if (movingDiskSize < targetDiskSize) {
                result.add(i)
            }
        }

        return result.toIntArray()
    }

    fun move(state: State, from: Int, to: Int): State {
        val movingDisk = state.towers[from].discs.pop()
        state.towers[to].discs.push(movingDisk)
        state.path.add(intArrayOf(from, to))
        return state
    }
}
