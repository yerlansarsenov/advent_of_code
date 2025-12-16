package day4

const val Space = '.'
const val Paper = '@'

fun main() {
    val grid = readInput()
    val h = grid.size
    val w = grid[0].size
    var sum = 0L
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (grid[i][j] == Space) {
                continue
            }
            if (getCountOfAdjacentPapers(grid, i, j) < 4) {
                sum++
            }
        }
    }
    println(sum)
}
