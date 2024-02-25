package fi.viware.aoc2023.day14

class Platform(inputLines: List<String>) {

    var platformArray = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    fun tilt(direction: Int){

    }

    fun getLoad(): Int{
        return 0
    }

    fun getLoadNorth(): Int{
        var load = 0
        platformArray.forEachIndexed { ir, chars ->
            load += getRowLoadNorth(ir)
        }
        return load
    }

    fun getRowLoadNorth(ir: Int): Int {
        var load = 0

        platformArray[ir].forEachIndexed { ic, c ->
            if (c == 'O') {
                load += platformArray.size - ir
                var irr = ir
                while (irr > 0 && platformArray[--irr][ic] != '#'){
                    if (platformArray[irr][ic] == '.') load += 1
                }
            }
        }
        return load
    }

    override fun toString(): String {
        return platformArray.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
    }
}