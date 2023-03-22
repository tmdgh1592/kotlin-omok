package view

import domain.player.Players
import domain.position.Position
import domain.stone.StoneColor
import view.mapper.toPresentation
import view.model.StoneColorModel

class OmokOutputView : OutputView {
    override fun onStartGame() {
        println(START_MESSAGE)
        println(EMPTY_BOARD)
        println(TURN_MESSAGE.format(StoneColorModel.BLACK.text))
    }

    override fun onEndGame(winnerStoneColor: StoneColor) {
        println(GAME_END_MESSAGE)
        println(WINNER_MESSAGE.format(winnerStoneColor.toPresentation().text))
    }

    override fun onStartTurn(stoneColor: StoneColor, position: Position) {
        print(TURN_MESSAGE.format(stoneColor.toPresentation().text))
        val viewPosition = position.toPresentation()
        println(LAST_STONE_POSITION_MESSAGE.format(viewPosition))
    }

    override fun onEndTurn(players: Players) {
        val board = EMPTY_BOARD.toMutableList()

        players.getBlackPlayer().getPositions().forEach {
            board[calculateIndex(it)] = BLACK_STONE
        }
        players.getWhitePlayer().getPositions().forEach {
            board[calculateIndex(it)] = WHITE_STONE
        }
        println(board.joinToString(separator = ""))
    }

    private fun calculateIndex(position: Position): Int = 721 + 3 * position.col - 48 * position.row

    companion object {
        private const val START_MESSAGE = "오목 게임을 시작합니다."
        private const val TURN_MESSAGE = "%s의 차례입니다. "
        private const val LAST_STONE_POSITION_MESSAGE = "(마지막 돌의 위치: %s)"
        private const val GAME_END_MESSAGE = "게임이 종료되었습니다."
        private const val WINNER_MESSAGE = "%s의 승리입니다."
        private val EMPTY_BOARD: String = """
            | 15 ┌──┬──┬──┬──┬──┬──┬──┬──┬──┬──┬──┬──┬──┬──┐
            | 14 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            | 13 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            | 12 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            | 11 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            | 10 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  9 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  8 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  7 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  6 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  5 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  4 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  3 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  2 ├──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┼──┤
            |  1 └──┴──┴──┴──┴──┴──┴──┴──┴──┴──┴──┴──┴──┴──┘
            |    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O
        """.trimMargin()
        private const val BLACK_STONE = '●'
        private const val WHITE_STONE = '○'
    }
}
