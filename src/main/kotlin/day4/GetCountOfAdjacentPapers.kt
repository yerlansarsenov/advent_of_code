package day4

fun getCountOfAdjacentPapers(grid: List<CharArray>, i: Int, j: Int): Long {
    var cnt = 0L
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
