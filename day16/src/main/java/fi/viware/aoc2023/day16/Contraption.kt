package fi.viware.aoc2023.day16

class Contraption(val inputLines: List<String>) {
    val mirrorBox = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    val visitBox = Array(inputLines.size) { row ->
        Array<String>(inputLines[row].length) { col ->
            "."        }
    }

    val beam = Beam(mirrorBox, visitBox)

    fun getNumberOfEnergizedTiles(): Int{
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