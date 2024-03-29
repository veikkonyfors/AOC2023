package fi.viware.aoc2023.day14

class Platform(inputLines: List<String>) {

    var platformArray = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    fun tiltNorth(): Platform{
        platformArray.forEachIndexed { ir, row ->
            1
            row.forEachIndexed { ic, c ->
                var irr = ir
                if (c == 'O') {
                    while (irr > 0) {
                        if (platformArray[irr-1][ic] in setOf('O','#')) break
                        if (platformArray[irr-1][ic] == '.') {
                            platformArray[irr-1][ic] = 'O'
                            platformArray[irr][ic] = '.'
                        }
                        irr--
                    }
                }
            }
        }
        return this
    }

    fun tiltWest(): Platform{
        platformArray.forEachIndexed { ir, row ->
            tiltWest(row)
        }
        return this
    }

    fun tiltWest(row: CharArray): CharArray{
        row.forEachIndexed { ic, c ->
            var icc = ic
            if (c == 'O') {
                while (icc > 0) {
                    if (row[icc-1] in setOf('O','#')) break
                    if (row[icc-1] == '.') {
                        row[icc-1] = 'O'
                        row[icc] = '.'
                    }
                    icc--
                }
            }
        }
        return row
    }

    fun tiltSouth(): Platform{
        platformArray = platformArray.reversedArray()
        tiltNorth()
        platformArray = platformArray.reversedArray()
        return this
    }

    fun tiltEast(row: CharArray): CharArray{
        return tiltWest(row.reversedArray()).reversedArray()
    }

    fun tiltEast(): Platform{
        platformArray.forEachIndexed { ir, row ->
            platformArray[ir] = tiltEast(row)
        }
        return this
    }

    fun oneRound(): Platform{
        tiltNorth()
        tiltWest()
        tiltSouth()
        tiltEast()
        return this
    }

    fun getLoad(): Int{
        var load = 0
        platformArray.forEachIndexed { ir, row ->
            row.forEachIndexed { ic, c ->
                if (c == 'O') {
                    load += platformArray.size - ir
                }
            }
        }
        return load
    }

    fun getHash(): String{
        return  this.toString().replace(Regex("\\n"), "")
    }

    /**
     * Get load for first tilt north, only for puzzle 1
     * For each row 0-10,
     * every O col height will be increased for each dot above the O col.
     */
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