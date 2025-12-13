package day3

fun main() {
    val lines = readInput()
    var sum = 0L
    for (line in lines) {
        sum += line.biggestBattery()
    }
    println(sum)
}

private fun String.biggestBattery(): Long {
    val indices = IntArray(size = 12)
    repeat(12) { time ->
        indices[time] = bestIndex(
            from = if (time == 0) {
                0
            } else {
                indices[time - 1] + 1
            },
            beforeLast = 11 - time
        )
    }
    println("for $this; indices = ${indices.map { it.toString() }}")
    println("concatDigitsIntoLong(indices) = ${concatDigitsIntoLong(indices)}")
    return concatDigitsIntoLong(indices)
}

private fun String.indexOfBestFirst(): Int {
    var index = 0
    for (i in 1 until lastIndex) {
        if (this[i] > this[index]) {
            index = i
        }
    }
    return index
}

private fun String.bestIndex(from: Int, beforeLast: Int): Int {
    var index = from
    for (i in from..(lastIndex - beforeLast)) {
        if (this[i] > this[index]) {
            index = i
        }
    }
    return index
}

private fun String.indexOfBestLast(indexOfFirst: Int): Int {
    var index = indexOfFirst + 1
    for (i in (indexOfFirst + 1)..lastIndex) {
        if (this[i] > this[index]) {
            index = i
        }
    }
    return index
}

private fun String.concatDigitsIntoLong(indices: IntArray): Long {
    return indices.mapIndexed { index, i ->
        10L.pow(indices.lastIndex - index) * this[i].digitToInt()
    }.sum()
}

private fun Long.pow(n: Int): Long {
    var res = 1L
    repeat(n) {
        res *= this
    }
    return res
}
