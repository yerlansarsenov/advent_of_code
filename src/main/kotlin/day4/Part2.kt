package day4

private const val Removed = 'x'

fun main() {
    val grid = readInput()
    val h = grid.size
    val w = grid[0].size
    var sum = 0L
    var iter = 0L
    do {
        var count = 0L
        val coordinatesToRemove = ArrayList<Pair<Int, Int>>()
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (grid[i][j] == Space || grid[i][j] == Removed) {
                    continue
                }
                if (getCountOfAdjacentPapers(grid, i, j) < 4) {
                    count++
                    coordinatesToRemove.add(i to j)
                }
            }
        }
        coordinatesToRemove.forEach { (i, j) ->
            grid[i][j] = Removed
        }
        println("iteration: ${iter++}")
        sum += count
    } while (count > 0L)
    println(sum)
}
