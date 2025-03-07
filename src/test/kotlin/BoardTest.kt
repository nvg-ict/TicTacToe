import nl.ns.dojo.Board
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class BoardTest {
    @Test
    fun `Given an instance of Board, Then instance is created`() {
        // Given
        val board = Board()

        // Then
        assertIs<Board>(board)
    }

    @Test
    fun `Given an empty Board, Then an empty 3 by 3 matrix is returned`() {
        // Given
        val board = Board()

        val expectedBoard = arrayOf(
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " ")
        )

        // Then
        assertEquals(
            expected = expectedBoard,
            actual = board.getBoard()
        )
    }
}