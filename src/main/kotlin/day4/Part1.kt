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

private fun getCountOfAdjacentPapers(grid: List<CharArray>, i: Int, j: Int): Int {
    var cnt = 0
    for (y in (i - 1)..(i + 1)) {
        for (x in (j - 1)..(j + 1)) {
            if (y == i && x == j) continue
            grid.getOrNull(y)?.getOrNull(x)?.let {
                if (it == Paper) {
                    cnt++
                }
            }
        }
    }
    return cnt
}
