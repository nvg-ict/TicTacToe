import nl.ns.dojo.Board
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertTrue

class BoardTest {
    private val board = Board()

    @Test
    fun `Given an instance of Board, Then instance is created`() {
        // Given

        // Then
        assertIs<Board>(board)
    }

    @Test
    fun `Given an empty Board, Then an empty 3 by 3 matrix is returned`() {
        // Given
        val currentBoard = board.getBoard()

        val expectedBoard = arrayOf(
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " ")
        )

        // Then
        assertTrue(currentBoard.contentDeepEquals(expectedBoard))
    }
}