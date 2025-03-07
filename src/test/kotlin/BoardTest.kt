import kotlin.test.Test
import kotlin.test.assertIs

class BoardTest {
    @Test
    fun `Given an instance of Board Then instance is created`() {
        val board = Board()
        assertIs<Board>(board)
    }
}