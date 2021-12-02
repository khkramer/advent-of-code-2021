fun main() {
    fun countIncreasingMeasurements(measurements: List<Int>): Int {
        var previousMeasurement = measurements.first()
        var total = 0
        measurements.forEach {
            if (it > previousMeasurement) {
                total++
            }

            previousMeasurement = it
        }

        return total
    }

    fun countGroupedIncreasingMeasurements(measurements: List<Int>): Int {
        return countIncreasingMeasurements(measurements.windowed(3).map { it.sum() })
    }

    val measurements = readInput("Day01").map { it.toInt() }
    println(countIncreasingMeasurements(measurements))
    println(countGroupedIncreasingMeasurements(measurements))
}
