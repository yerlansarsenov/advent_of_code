package day5

fun main() {
    val input = readInput()
    var freshCount = 0
    for (id in input.ids) {
        var isFresh = false
        for (range in input.ranges) {
            if (id in range) {
                isFresh = true
                break
            }
        }
        if (isFresh) {
            freshCount++
        }
    }
    println(freshCount)
}
