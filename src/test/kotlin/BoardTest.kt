import nl.ns.dojo.Board
import nl.ns.dojo.Field
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

class BoardTest {
    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        // Initialize the board before each test
        board = Board()
    }

    @Test
    fun `Given an instance of Board, Then instance is created`() {
        // Given

        // Then
        assertIs<Board>(board)
    }

    @Test
    fun `Given an empty Board, Then an empty 3 by 3 matrix is returned`() {
        // Given

        // Then
        val currentBoard = board.getBoard()

        val expectedBoard = arrayOf(
            arrayOf(Field.Empty, Field.Empty, Field.Empty),
            arrayOf(Field.Empty, Field.Empty, Field.Empty),
            arrayOf(Field.Empty, Field.Empty, Field.Empty),
        )

        assertTrue(currentBoard.contentDeepEquals(expectedBoard))
    }

    @Test
    fun `Given an empty Board, When adding a X at (0,0), Then a X in the top left is returned`() {
        // Given

        // When
        board.addMove(0,0, Field.X)

        // Then
        val currentBoard = board.getBoard()

        val expectedBoard = arrayOf(
            arrayOf(Field.X, Field.Empty, Field.Empty),
            arrayOf(Field.Empty, Field.Empty, Field.Empty),
            arrayOf(Field.Empty, Field.Empty, Field.Empty),
        )

        assertTrue(currentBoard.contentDeepEquals(expectedBoard))
    }

    @Test
    fun `Given an empty Board with a X at (0,0), When adding a O on that position, Then the add function returns false`() {
        // Given
        board.addMove(0,0, Field.X)

        // When
        val result = board.addMove(0,0, Field.O)

        // Then
        assertFalse(result)
    }
}