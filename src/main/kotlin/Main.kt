package nl.ns.dojo


fun main() {
    val player1 = Bot(Field.X)
    val player2 = Bot(Field.O)

    val board = Board()

    var currentPlayer = player1
    var winner: Bot? = null

    printBoard(board.getBoard())
    while(true) {
        val move = currentPlayer.getRandomMove(board.getBoard())
        if(move == null) {
            break
        }

        board.addMove(move.first, move.second, currentPlayer.symbol)

        println("Player ${currentPlayer.symbol}:")
        printBoard(board.getBoard())

        if (Winning()(board.getBoard())) {
            winner = currentPlayer
            break
        }

        currentPlayer = if(currentPlayer == player1) player2 else player1
    }

    println(if (winner != null) "PLAYER ${winner.symbol} WON!" else "It's a draw!")
}

fun printBoard(board: Array<Array<Field>>) {
    board.forEachIndexed { i, row ->
        println(row.joinToString("|") { it.symbol })
        if (i < board.size - 1) println("-+-+-")
    }
    println()
}