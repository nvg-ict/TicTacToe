package nl.ns.dojo


class Board {
    private val board: Array<Array<Field>> = Array(3) { Array (3) { Field.Empty } }

    fun getBoard(): Array<Array<Field>> = board

    fun addMove(row: Int, column: Int, symbol: Field): Boolean {
        return if(board[row][column] == Field.Empty) {
            board[row][column] = symbol
            true
        } else {
            false
        }
    }
}
