package fi.viware.aoc2023.day9

class History(historyLine: String) {
    val values = historyLine.split(" ").map { it.toInt() }.toMutableList()
    var evalues:MutableList<MutableList<Int>> = mutableListOf()

    init {
        evalues.add(values)
    }

    fun extrapolate(){

        // First iterate to all zero difference line
        while ( ! evalues[evalues.size -1].all { it == 0} ){
        var differenceLine:MutableList<Int> = mutableListOf()
        differenceLine = evalues[evalues.size - 1].zipWithNext { a, b -> b - a  }.toMutableList()
        evalues.add(differenceLine)
        }

        // Then add an item to each line
        evalues.forEachIndexed { index, intsList ->
            if (index == evalues.size - 1) return@forEachIndexed
            var toAdd: Int = 0
            evalues.last().add(0)
            if (index != evalues.size - 1) {
                val secondLastPreviousLine = evalues[evalues.size - 2 - index]
                val lastLine = evalues[evalues.size - 1 - index]
                val lastLinesLast = lastLine.last()
                val secondLastPreviousLineSecondLastInt = secondLastPreviousLine[secondLastPreviousLine.size-1]
                toAdd = secondLastPreviousLineSecondLastInt + lastLinesLast
                val x = ""
            }
            val indexToAdd = evalues.size - 2 - index
            evalues[indexToAdd].add(toAdd)
        }

    }

    override fun toString(): String {
        return values.joinToString(separator = " ") { it.toString() }
    }

}