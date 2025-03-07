package nl.ns.dojo

class Board {
    private val board: Array<Array<String>> = Array(3) { Array (3) { " " } }

    fun getBoard(): Array<Array<String>> = board

    fun addMove(row: Int, column: Int, symbol: String) {
        board[row][column] = symbol
    }
}
