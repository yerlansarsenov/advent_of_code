package day3

import java.io.File

fun readInput(): List<String> {
    val url = File("src/main/kotlin/day3/input")
    val rawText: String = url.readText()
    return rawText.split("\n")
}
