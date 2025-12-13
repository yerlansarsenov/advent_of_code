package day2

fun main() {
    println(getSumOfInvalidIDs())
}

private fun getSumOfInvalidIDs(): Long {
    val ranges = readInput()
    var sum = 0L
    for (range in ranges) {
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
    if (numOfDigits % 2 != 0) {
        return false
    }
    val firstHalf = this.toString().substring(startIndex = 0, endIndex = numOfDigits / 2)
    val secondHalf = this.toString().substring(startIndex = numOfDigits / 2, endIndex = numOfDigits)
    return firstHalf == secondHalf
}
