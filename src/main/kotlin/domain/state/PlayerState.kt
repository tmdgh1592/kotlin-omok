package domain.state

import domain.position.Position
import domain.rule.OmokRule
import domain.stone.Stone
import domain.stone.Stones

abstract class PlayerState(protected val stones: Stones = Stones()) {
    abstract val isPlaying: Boolean

    abstract val isFoul: Boolean

    abstract fun add(newStone: Stone, rule: OmokRule): PlayerState

    fun hasStone(stone: Stone): Boolean = stones.hasStone(stone)

    fun getPlaced(): List<Position> = stones.getPositions()

    fun getLastStone(): Stone = stones.lastStone

    fun getAllStones(): Stones = stones.copy()
}
