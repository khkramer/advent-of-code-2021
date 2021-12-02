typealias Commands = List<Pair<String, Int>>

fun Commands.totalValueOf(command: String) = filter { it.first == command }.sumOf { it.second }

fun main() {
    fun firstInterpretationOfCommands(commands: Commands): Int {
        val horizontalPosition = commands.totalValueOf("forward")
        val depth = commands.totalValueOf("down") - commands.totalValueOf("up")

        return horizontalPosition * depth
    }

    val commands = readInput("Day02").map {
        it.split(' ').let {
            Pair(it[0], it[1].toInt())
        }
    }
    println(firstInterpretationOfCommands(commands))
}