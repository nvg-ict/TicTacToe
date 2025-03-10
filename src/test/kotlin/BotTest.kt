import nl.ns.dojo.Bot
import kotlin.test.*

class BotTest {
    private val bot = Bot()

    @Test
    fun `Given an empty board, when the bot generates a move, then a position is given`() {
        // Given
        val board = arrayOf(
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " ")
        )

        // When
        val move = bot.getRandomMove(board)

        // Then
        assertNotNull(move)
        val (row, col) = move
        assertTrue(row in 0..2)
        assertTrue(col in 0..2)
    }

    @Test
    fun `Given an full board, when the bot generates a move, then null is returned`() {
        // Given
        val board = arrayOf(
            arrayOf("X", "X", "X"),
            arrayOf("X", "X", "X"),
            arrayOf("X", "X", "X"),
        )

        // When
        val move = bot.getRandomMove(board)

        // Then
        assertNull(move)
    }

    @Test
    fun `Given a partially filled board, When bot moves, Then move is in an empty cell`() {
        // Given
        val board = arrayOf(
            arrayOf("X", " ", "O"),
            arrayOf(" ", "X", " "),
            arrayOf("O", " ", "X")
        )

        // When
        val move = bot.getRandomMove(board)

        // Then
        assertNotNull(move)
        val (row, col) = move
        assertEquals(" ", board[row][col])
    }
}