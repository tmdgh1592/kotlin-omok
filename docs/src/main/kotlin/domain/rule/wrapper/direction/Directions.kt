package rule.wrapper.direction

import domain.rule.Col
import domain.rule.Direction
import domain.rule.Row
import domain.rule.other.Iterator
import domain.rule.wrapper.direction.DirectionsIterator

internal class Directions {
    fun iterator(): Iterator<Direction<Row, Col>> = DirectionsIterator(all())

    companion object {
        private val TOP_DIRECTION = Direction(1, 0)
        private val BOTTOM_DIRECTION = Direction(-1, 0)
        private val LEFT_DIRECTION = Direction(0, -1)
        private val RIGHT_DIRECTION = Direction(0, 1)
        private val LEFT_BOTTOM_DIRECTION = Direction(-1, -1)
        private val RIGHT_TOP_DIRECTION = Direction(1, 1)
        private val LEFT_TOP_DIRECTION = Direction(1, -1)
        private val RIGHT_BOTTOM_DIRECTION = Direction(-1, 1)

        private fun all(): List<Direction<Row, Col>> = listOf(
            TOP_DIRECTION, BOTTOM_DIRECTION,
            LEFT_DIRECTION, RIGHT_DIRECTION,
            LEFT_BOTTOM_DIRECTION, RIGHT_TOP_DIRECTION,
            LEFT_TOP_DIRECTION, RIGHT_BOTTOM_DIRECTION,
        )
    }
}
