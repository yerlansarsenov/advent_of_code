package day5

fun main() {
    val ranges = readInput().ranges.sortedBy {
        it.first
    }
    println(countFreshIds(ranges))
}

private fun countFreshIds(ranges: List<LongRange>): Long {
    if (ranges.isEmpty()) return 0
    val sorted = ranges.sortedBy { it.first }
    var total = 0L
    var currentStart = sorted[0].first
    var currentEnd = sorted[0].last
    for (i in 1 until sorted.size) {
        val range = sorted[i]
        if (range.first <= currentEnd + 1) {
            currentEnd = maxOf(currentEnd, range.last)
        } else {
            total += currentEnd - currentStart + 1
            currentStart = range.first
            currentEnd = range.last
        }
    }
    total += currentEnd - currentStart + 1
    return total
}
