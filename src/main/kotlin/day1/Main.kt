package day1

import java.io.File

fun main() {
    val input = readInput()
        .map { Turn(it) }
    var current = 50
    var zeroCounter = 0
    for (t in input) {
        current = t.getDiff(current)
        println(current)
        if (current == 0) {
            zeroCounter++
        }
    }
    println(zeroCounter)
}

private fun readInput(): List<String> {
    val url = File("src/main/kotlin/day1/input")
    val rawText: String = url.readText()
    return rawText.split("\n")
}

class Turn(
    private val direction: Direction,
    private val step: Int
) {
    // 50
    // +R212
    // 50 + 212 = 272

    // 50
    // +R99
    // 50 + 99 = 149
    constructor(from: String) : this(
        Direction.valueOf(from[0].toString()),
        from.substring(1).toInt() % 100
    )

    enum class Direction {
        L, R
    }

    fun getDiff(current: Int): Int {
        var diff = when (direction) {
            Direction.L -> current - step
            Direction.R -> current + step
        }
        if (diff < 0) {
            diff += 100
        }
        return diff % 100
    }
}
