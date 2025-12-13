package day2

fun main() {
    println(getSumOfInvalidIDs())
}

private fun getSumOfInvalidIDs(): Long {
    val ranges = readInput()
    var sum = 0L
    for (range in ranges) {
        println("range = $range; ids = ${range.findInvalidIdsInRange()}")
        sum += range.findInvalidIdsInRange().sum()
    }
    return sum
}

private fun LongRange.findInvalidIdsInRange(): List<Long> {
    return this.filter { number ->
        number.isInvalidID()
    }
}

private fun Long.isInvalidID(): Boolean {
    val numOfDigits = this.toString().length
    var divideBy = 2
    println("isInvalidID: $this")
    while (divideBy <= numOfDigits) {
        println("isInvalidID: while divideBy <= numOfDigits: $divideBy <= $numOfDigits")
        println("isInvalidID: while: numOfDigits % divideBy: ${numOfDigits % divideBy}")
        if (numOfDigits % divideBy == 0) {
            val parts = this.toString().divideIntoParts(divideBy)
            println("isInvalidID: while: parts = $parts; parts.allSame() = ${parts.allSame()}")
            if (parts.allSame()) {
                return true
            }
        }
        divideBy++
    }
    return false
}

private fun String.divideIntoParts(by: Int): List<String> {
    val parts = mutableListOf<String>()
    val divideBy = length / by
    repeat(by) { index ->
        val part = this.substring(startIndex = index * divideBy, endIndex = index * divideBy + divideBy)
        parts.add(part)
    }
    return parts
}

private fun List<String>.allSame(): Boolean {
    if (isEmpty()) return false
    for (i in 1..lastIndex) {
        if (first() != this[i]) {
            return false
        }
    }
    return true
}
