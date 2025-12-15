package day4

import java.io.File

fun readInput(): List<CharArray> {
    val url = File("src/main/kotlin/day4/input")
    val rawText: String = url.readText()
    return rawText.split("\n")
        .map { line ->
            line.toCharArray()
        }
}
