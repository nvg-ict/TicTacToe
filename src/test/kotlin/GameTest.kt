import nl.ns.dojo.Game
import kotlin.test.Test
import kotlin.test.assertIs

class GameTest {
    @Test
    fun `Given an instance of Game, Then instance is created`() {
        // Given
        val game = Game()

        // Then
        assertIs<Game>(game)
    }
}