import io.mockk.every
import io.mockk.mockk
import nl.ns.dojo.Board
import nl.ns.dojo.Game
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertTrue

class GameTest {
    @Test
    fun `Given an instance of Game, Then instance is created`() {
        // Given
        val game = Game(board = mockk<Board>())

        // Then
        assertIs<Game>(game)
    }

    @Test
    fun `Given a winning board, When game checks win, Then win is given`() {
        // Given
        val mockedBoard = mockk<Board>()
        every { mockedBoard.getBoard() } returns arrayOf(
            arrayOf("X", " ", " "),
            arrayOf("X", " ", " "),
            arrayOf("X", " ", " ")
        )

        val game = Game(board = mockedBoard)

        // When
        val result = game.isWon()

        // Then
        assertTrue(result)
    }
}