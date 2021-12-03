fun <T> List<T>.mostCommonItem() : T? {
    return groupBy { it }
        .maxByOrNull { it.value.size }
        ?.key
}

fun <T> List<T>.leastCommonItem() : T? {
    return groupBy { it }
        .minByOrNull { it.value.size }
        ?.key
}

fun main() {
    fun part1(input: List<String>): Int {
        val binaryNumbers = input.map {
            it.toCharArray()
        }

        val columns = mutableListOf<List<Int>>()
        repeat(12) { index ->
            columns.add(
                binaryNumbers.map { it[index].toString().toInt() }
            )
        }

        val gammaNumber = columns.map {
            it.mostCommonItem()
        }.joinToString("").toInt(2)

        val epsilonNumber = columns.map {
            it.leastCommonItem()
        }.joinToString("").toInt(2)

        return gammaNumber * epsilonNumber
    }

    println(part1(readInput("Day03")))
}