import nl.ns.dojo.Bot
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BotTest {
    @Test
    fun `Given an empty board, when the bot generates a move, then a position is given`() {
        // Given
        val bot = Bot()
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
        val bot = Bot()
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
}