import nl.ns.dojo.Bot
import kotlin.test.Test
import kotlin.test.assertNotNull
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
}