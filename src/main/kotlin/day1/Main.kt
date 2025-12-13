package day1

import java.io.File

fun main() {
    part2()
}

private fun part1() {
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

private fun part2() {
    val input = readInput()
        .map { Turn2(it) }
    var current = 50
    var zeroCounter = 0
    for (t in input) {
        val (diff, zeroCount) = t.getDiffAndZeroCounts(current)
        current = diff
        println("curr $current")
        println(" zero $zeroCounter")
        zeroCounter += zeroCount
    }
    println(zeroCounter)
}

private fun readInput(): List<String> {
    val url = File("src/main/kotlin/day1/input")
    val rawText: String = url.readText()
    return rawText.split("\n")
}

enum class Direction {
    L, R
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

class Turn2(
    private val direction: Direction,
    private val step: Int
) {
    constructor(from: String) : this(
        Direction.valueOf(from[0].toString()),
        from.substring(1).toInt()
    )

    fun getDiffAndZeroCounts(current: Int): TurnResult {
        var zeroCounts = 0
        var res = current
        repeat(step) {
            res += when (direction) {
                Direction.L -> -1
                Direction.R -> 1
            }
            val zHelper = if (res < 0) res * -1 else res
            if (zHelper % 100 == 0) {
                zeroCounts++
            }
        }
        while (res < 0) {
            res += 100
        }
        return TurnResult(
            position = res % 100,
            zeroCounts = zeroCounts
        )
    }
}

data class TurnResult(
    val position: Int,
    val zeroCounts: Int
)
