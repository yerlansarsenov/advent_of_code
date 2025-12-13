package day2

import java.io.File

fun readInput(): List<LongRange> {
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
