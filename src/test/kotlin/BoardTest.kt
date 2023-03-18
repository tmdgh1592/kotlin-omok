
import domain.player.BlackPlayer
import domain.player.Player
import domain.player.WhitePlayer
import domain.state.PlayingState
import domain.stone.Stones
import org.junit.jupiter.api.Test

class BoardTest {
    @Test
    fun `특정 위치에 돌을 놓으면 플레이어를 반환한다`() {
        val blackPlayer: Player = BlackPlayer(PlayingState(Stones(ONE_ONE_STONE)))
        val whitePlayer: Player = WhitePlayer(PlayingState(Stones(ONE_TWO_STONE)))
        // val board = Board(blackPlayer, whitePlayer)
        // assertThat(board.putStone(StoneColor.BLACK, ONE_THREE_STONE)).isInstanceOf(Player::class.java)
    }

    @Test
    fun `특정 위치에 돌을 놓지 못하면 null을 반환한다`() {
        val blackPlayer: Player = BlackPlayer(PlayingState(Stones(ONE_ONE_STONE)))
        val whitePlayer: Player = WhitePlayer(PlayingState(Stones(ONE_TWO_STONE)))
        // val board = Board(blackPlayer, whitePlayer)
        // assertThat(board.putStone(StoneColor.BLACK, ONE_TWO_STONE)).isNull()
    }
}
