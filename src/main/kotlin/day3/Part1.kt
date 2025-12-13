package day3

fun main() {
    println(getSumOfInvalidIDs())
}

private fun getSumOfInvalidIDs(): Long {
    val lines = readInput()
    var sum = 0L
    for (line in lines) {
        sum += line.biggestBattery()
    }
    return sum
}

private fun String.biggestBattery(): Int {
    val indexOfFirst = indexOfBestFirst()
    val indexOfLast = indexOfBestLast(indexOfFirst)
    return this[indexOfFirst].digitToInt() * 10 + this[indexOfLast].digitToInt()
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

private fun String.indexOfBestLast(indexOfFirst: Int): Int {
    var index = indexOfFirst + 1
    for (i in (indexOfFirst + 1)..lastIndex) {
        if (this[i] > this[index]) {
            index = i
        }
    }
    return index
}
