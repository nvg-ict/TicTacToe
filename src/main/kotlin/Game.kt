package nl.ns.dojo

class Game(val board: Board) {
    fun isWon(): Boolean {
        val board = board.getBoard()
        // Check rows
        for (row in board) {
            if (row[0] != " " && row[0] == row[1] && row[1] == row[2]) {
                return true
            }
        }

        // Check columns
        for (col in 0 until 3) {
            if (board[0][col] != " " && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true
            }
        }

        return false
    }
}
