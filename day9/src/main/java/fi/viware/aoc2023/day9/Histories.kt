package fi.viware.aoc2023.day9

class Histories(inputLines: List<String>) {

    var historyList = listOf<History>()

    init {
        historyList = inputLines.map {
            History(it)
        }
    }

    override fun toString(): String {
        return historyList.joinToString(separator = "\n") { it.toString() }
    }
}