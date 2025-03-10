package nl.ns.dojo

interface Board {
    fun getBoard(): Array<Array<String>>
    fun addMove(row: Int, column: Int, symbol: String): Boolean
}

class BoardImpl: Board {
    private val board: Array<Array<String>> = Array(3) { Array (3) { " " } }

    override fun getBoard(): Array<Array<String>> = board

    override fun addMove(row: Int, column: Int, symbol: String): Boolean {
        return if(board[row][column] == " ") {
            board[row][column] = symbol
            true
        } else {
            false
        }
    }
}
