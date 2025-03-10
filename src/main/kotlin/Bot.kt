package nl.ns.dojo

class Bot {
    fun getRandomMove(board: Array<Array<String>>): Pair<Int, Int>? {
        val emptyCells = mutableListOf<Pair<Int, Int>>()

        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == " ") {
                    emptyCells.add(row to col)
                }
            }
        }

        return if (emptyCells.isNotEmpty()) emptyCells.random() else null
    }
}
