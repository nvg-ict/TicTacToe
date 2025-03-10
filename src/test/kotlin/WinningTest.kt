import nl.ns.dojo.Field
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
        fun provideWinningBoards(): Stream<Array<Array<Field>>> = Stream.of(
            arrayOf( // Winning row
                arrayOf(Field.X, Field.X, Field.X),
                arrayOf(Field.Empty, Field.Empty, Field.Empty),
                arrayOf(Field.Empty, Field.Empty, Field.Empty)
            ),
            arrayOf( // Winning column
                arrayOf(Field.O, Field.Empty, Field.Empty),
                arrayOf(Field.O, Field.Empty, Field.Empty),
                arrayOf(Field.O, Field.Empty, Field.Empty)
            ),
            arrayOf( // Complex winning row
                arrayOf(Field.O, Field.X, Field.O),
                arrayOf(Field.O, Field.O, Field.X),
                arrayOf(Field.X, Field.X, Field.X)
            ),
            arrayOf( // Complex winning column
                arrayOf(Field.O, Field.X, Field.O),
                arrayOf(Field.O, Field.X, Field.O),
                arrayOf(Field.X, Field.O, Field.O)
            ),
            arrayOf( // Winning diagonal
                arrayOf(Field.X, Field.Empty, Field.O),
                arrayOf(Field.Empty, Field.X, Field.Empty),
                arrayOf(Field.O, Field.Empty, Field.X)
            ),
            arrayOf( // Winning diagonal 2
                arrayOf(Field.X, Field.Empty, Field.O),
                arrayOf(Field.Empty, Field.O, Field.Empty),
                arrayOf(Field.O, Field.Empty, Field.X)
            )
        )

        @JvmStatic
        fun provideNotWinningBoards(): Stream<Array<Array<Field>>> = Stream.of(
            arrayOf(
                arrayOf(Field.O, Field.Empty, Field.Empty),
                arrayOf(Field.O, Field.Empty, Field.Empty),
                arrayOf(Field.Empty, Field.Empty, Field.Empty)
            ),
            arrayOf(
                arrayOf(Field.X, Field.Empty, Field.Empty),
                arrayOf(Field.X, Field.Empty, Field.Empty),
                arrayOf(Field.O, Field.O, Field.Empty)
            ),
            arrayOf(
                arrayOf(Field.X, Field.X, Field.O),
                arrayOf(Field.O, Field.O, Field.X),
                arrayOf(Field.X, Field.O, Field.X)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("provideWinningBoards")
    fun `Given a winning board, When game checks win, Then win is given`(winningBoard: Array<Array<Field>>) {
        // Given

        // When
        val result = winning(winningBoard)

        // Then
        assertTrue(result)
    }

    @ParameterizedTest
    @MethodSource("provideNotWinningBoards")
    fun `Given a non-winning board, When game checks win, Then win is not given`(notWinningBoard: Array<Array<Field>>) {
        // Given

        // When
        val result = winning(notWinningBoard)

        // Then
        assertFalse(result)
    }
}