package fi.viware.aoc2023.day5

class TransFormLine(transFormLineString: String) {

    var destinationStart: Long
    var sourceStart: Long
    var rangeLenght: Long

    init{
        val listOfBounds = transFormLineString.split(" ")
        destinationStart = listOfBounds[0].toLong()
        sourceStart = listOfBounds[1].toLong()
        rangeLenght = listOfBounds[2].toLong()
    }

    override fun toString(): String {
        return "$destinationStart, $sourceStart, $rangeLenght"
    }
}