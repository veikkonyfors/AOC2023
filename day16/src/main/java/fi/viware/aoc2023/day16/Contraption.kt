package fi.viware.aoc2023.day16

class Contraption(val inputLines: List<String>) {
    val mirrorBox = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    var visitBox = Array(inputLines.size) { row ->
        Array<String>(inputLines[row].length) { col ->
            "."        }
    }

    var beam = Beam(mirrorBox, visitBox)

    fun getMaxNumberOfEnergizedTiles(): Int {

        var maxNumberOfEnergizedTiles = 0
        var direction = DOWN
        var n = 0


        fun count(row: Int, col: Int, direction: Int): Int {

            visitBox = Array(mirrorBox.size) { row ->
                Array<String>(mirrorBox[col].size) { col -> "." }
            }

            beam = Beam(mirrorBox, visitBox, row, col, direction)
            beam.stepAhead()
            val n = countNumberOfEnergizedTilesOnPuzz1()
            //println("$row, $col, $direction: $n")
            return maxOf(maxNumberOfEnergizedTiles, n)
        }

        for (row in 0..mirrorBox.size - 1)
            for( col in 0..mirrorBox[0].size - 1) {

                if (row == 0) { maxNumberOfEnergizedTiles = count(row,col, DOWN)}
                if (row == mirrorBox.size - 1) { maxNumberOfEnergizedTiles = count(row,col, UP)}
                if (col == 0) { maxNumberOfEnergizedTiles = count(row,col, RIGHT)}
                if (col == mirrorBox.size - 1) { maxNumberOfEnergizedTiles = count(row,col, LEFT)}
            }

        return maxNumberOfEnergizedTiles
    }



    fun countNumberOfEnergizedTilesOnPuzz1(): Int{
        val a = visitBox.flatten()
        val b = a.count { it != "." }
        return visitBox.flatten().count { it != "." }
    }

    override fun toString(): String {
        var s = ""
        s = mirrorBox.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
        s += "\n\n"

        s += visitBox.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
        s += '\n'
        return s
    }
}