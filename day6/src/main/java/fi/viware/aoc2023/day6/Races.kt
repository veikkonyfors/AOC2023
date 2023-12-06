package fi.viware.aoc2023.day6

class Races(inputLines: List<String>) {

    val raceList: MutableList<Race> = mutableListOf()

    val regex = "\\b\\d+\\b".toRegex()
    val times = regex.findAll(inputLines[0]).map { it.value }.toList()
    val distances = regex.findAll(inputLines[1]).map { it.value }.toList()

    init {
        times.forEachIndexed { i, s ->
            raceList.add(Race(s.toLong(), distances[i].toLong()))
        }
    }

    override fun toString(): String {

        return raceList.joinToString {
            "$it, "
        }
    }

}