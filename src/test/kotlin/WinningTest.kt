import nl.ns.dojo.Winning
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertTrue

class WinningTest {
    private lateinit var winning: Winning

    @BeforeEach
    fun setup() {
        winning = Winning()
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
            ),
            arrayOf( // Winning diagonal
                arrayOf("X", " ", "O"),
                arrayOf(" ", "X", " "),
                arrayOf("O", " ", "X")
            ),
            arrayOf( // Winning diagonal 2
                arrayOf("X", " ", "O"),
                arrayOf(" ", "O", " "),
                arrayOf("O", " ", "X")
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
    fun `Given a winning board, When game checks win, Then win is given`(winningBoard: Array<Array<String>>) {
        // Given

        // When
        val result = winning(winningBoard)

        // Then
        assertTrue(result)
    }

    @ParameterizedTest
    @MethodSource("provideNotWinningBoards")
    fun `Given a non-winning board, When game checks win, Then win is not given`(notWinningBoard: Array<Array<String>>) {
        // Given

        // When
        val result = winning(notWinningBoard)

        // Then
        assertFalse(result)
    }
}