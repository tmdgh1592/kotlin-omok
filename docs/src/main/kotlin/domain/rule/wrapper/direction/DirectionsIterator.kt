package domain.rule.wrapper.direction

import domain.rule.Col
import domain.rule.Direction
import domain.rule.Row
import domain.rule.other.Iterator

internal class DirectionsIterator(items: List<Direction<Row, Col>>) : Iterator<Direction<Row, Col>> {
    private val _items: MutableList<Direction<Row, Col>> = items.deepCopy()

    override fun hasNext(): Boolean = _items.isNotEmpty()

    override fun next(): Direction<Row, Col> {
        check(hasNext()) { "The next direction does not exist." }
        return _items.removeFirst()
    }

    private fun List<Direction<Row, Col>>.deepCopy(): MutableList<Direction<Row, Col>> =
        map { it.copy() }.toMutableList()
}
