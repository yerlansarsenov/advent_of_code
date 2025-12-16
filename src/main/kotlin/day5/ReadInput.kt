package day5

import java.io.File

fun readInput(): Input {
    val url = File("src/main/kotlin/day5/input")
    val (ranges, ids) = url.readText()
        .split("\n\n")

    return Input(
        ranges = ranges.split("\n")
            .map {
                val (start, end) = it.split("-")
                start.toLong()..end.toLong()
            },
        ids = ids.split("\n")
            .map { it.toLong() }
    )
}

class Input(
    val ranges: List<LongRange>,
    val ids: List<Long>
) {
    override fun toString(): String {
        return "Input(ranges=${ranges.size}; ids=${ids.size})"
    }
}
