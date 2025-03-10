import io.mockk.every
import io.mockk.mockk
import nl.ns.dojo.Board
import nl.ns.dojo.Game
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
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
    companion object {
        @JvmStatic
        fun provideWinningBoards(): Stream<Array<Array<String>>> = Stream.of(
            arrayOf( // Winning row
                arrayOf("X", "X", "X"),
                arrayOf(" ", " ", " "),
                arrayOf(" ", " ", " ")
            ),
            arrayOf( // Winning column
                arrayOf("O", " ", " "),
                arrayOf("O", " ", " "),
                arrayOf("O", " ", " ")
            ),
            arrayOf( // Complex winning row
                arrayOf("O", "X", "O"),
                arrayOf("O", "O", "X"),
                arrayOf("X", "X", "X")
            ),
            arrayOf( // Complex winning column
                arrayOf("O", "X", "O"),
                arrayOf("O", "X", "O"),
                arrayOf("X", "O", "O")
            )
        )

        @JvmStatic
        fun provideNotWinningBoards(): Stream<Array<Array<String>>> = Stream.of(
            arrayOf(
                arrayOf("O", " ", " "),
                arrayOf("O", " ", " "),
                arrayOf(" ", " ", " ")
            ),
            arrayOf(
                arrayOf("X", " ", " "),
                arrayOf("X", " ", " "),
                arrayOf("O", "O", " ")
            ),
            arrayOf(
                arrayOf("X", "X", "O"),
                arrayOf("O", "O", "X"),
                arrayOf("X", "O", "X")
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("provideWinningBoards")
    fun `Given a winning board, When game checks win, Then win is given`(boardState: Array<Array<String>>) {
        // Given
        val mockedBoard = mockk<Board>()
        every { mockedBoard.getBoard() } returns boardState
        val game = Game(board = mockedBoard)

        // When
        val result = game.isWon()

        // Then
        assertTrue(result)
    }

    @ParameterizedTest
    @MethodSource("provideNotWinningBoards")
    fun `Given a non-winning board, When game checks win, Then win is not given`(boardState: Array<Array<String>>) {
        // Given
        val mockedBoard = mockk<Board>()
        every { mockedBoard.getBoard() } returns boardState
        val game = Game(board = mockedBoard)

        // When
        val result = game.isWon()

        // Then
        assertFalse(result)
    }
}