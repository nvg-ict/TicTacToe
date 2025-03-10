package nl.ns.dojo

typealias BoardCanvas = Array<Array<Field>>

class Winning {
    operator fun invoke(board: BoardCanvas): Boolean {
        // Check rows
        for (row in board) {
            if (row[0] != Field.Empty && row[0] == row[1] && row[1] == row[2]) {
                return true
            }
        }

        // Check columns
        for (col in 0 until 3) {
            if (board[0][col] != Field.Empty && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true
            }
        }

        // Check diagonals
        if (board[0][0] != Field.Empty && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true
        }
        if (board[0][2] != Field.Empty && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true
        }

        return false
    }
}
