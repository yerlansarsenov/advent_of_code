package day2

import java.io.File

fun main() {

}

private fun partOne() {
    println(getSumOfInvalidIDsPart1())
}

private fun readInput(): List<LongRange> {
    val url = File("src/main/kotlin/day2/input")
    val rawText: String = url.readText()
    return rawText.split(",")
        .map { text ->
            val numbers = text.split("-")
                .map { it.toLong() }
            require(numbers.size == 2)
            numbers[0]..numbers[1]
        }
}

private fun getSumOfInvalidIDsPart1(): Long {
    val ranges = readInput()
    var sum = 0L
    for (range in ranges) {
        sum += range.findInvalidIdsInRangePart1().sum()
    }
    return sum
}

private fun LongRange.findInvalidIdsInRangePart1(): List<Long> {
    return this.filter { number ->
        number.isInvalidIDPart1()
    }
}

private fun Long.isInvalidIDPart1(): Boolean {
    val numOfDigits = this.toString().length
    if (numOfDigits % 2 != 0) {
        return false
    }
    val firstHalf = this.toString().substring(startIndex = 0, endIndex = numOfDigits / 2)
    val secondHalf = this.toString().substring(startIndex = numOfDigits / 2, endIndex = numOfDigits)
    return firstHalf == secondHalf
}
