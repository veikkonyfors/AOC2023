package fi.viware.aoc2023.day3

class Schematic(val inputLines: List<String>) {

    var schema = Array(inputLines.size) { CharArray(inputLines[0].length)}
    var numRows = 0
    var numCols = 0

    init{
        var ir = 0
        var ic = 0

        inputLines.forEach { r ->
            ic = 0
            r.forEach { c ->
                schema[ir][ic] = c
                ic += 1
            }
            ir += 1
        }

        numRows = schema.size
        numCols = schema[0].size

    }

    fun addUp(): Int{
        var addUp: Int = 0
        var numberString = ""
        var isAdjacent = false

        schema.forEachIndexed { ir, r ->
            r.forEachIndexed { ic, c ->
                if (c.isDigit()) {
                    numberString += c
                    if ( isAdjacent(ir, ic) )
                        isAdjacent = true
                }
                else {
                    if (!numberString.isEmpty() && isAdjacent) {
                        addUp += numberString.toInt()
                        println("Adding up: $numberString")
                    }
                    numberString = ""
                    isAdjacent = false
                }
                if (ic == numCols - 1 && numberString != "" && isAdjacent) {  // end of line cuts the number
                    addUp += numberString.toInt()
                    println("Adding up: $numberString")
                    numberString = ""
                    isAdjacent = false
                }

            }
        }
        return addUp
    }

    fun gearRatio(): Int{
        var gearRatio = 1
        var adjacentNumbers = mutableSetOf<adjacentNumber>()
        var product = 0
        var sum = 0
        schema.forEachIndexed { ir, r ->
            r.forEachIndexed { ic, c ->
                if (c == '*') {
                    var a = findAdjacentNumbers(ir, ic)
                    if (a.size == 2) {
                        adjacentNumbers.addAll(a)
                        val adjacentNumber1 = a.first()
                        val adjacentNumber2 = a.last()
                        product = adjacentNumber1.Number * adjacentNumber2.Number
                        sum += product
                    }


                }
            }
        }

        //adjacentNumbers.forEach { gearRatio = gearRatio * it.Number}

        return sum
    }

    fun findAdjacentNumbers(ir:Int, ic: Int): Set<adjacentNumber> {
        var adjacentNumbers: MutableList<adjacentNumber> = mutableListOf()
        for (ix in arrayOf(-1, 0, 1))
            for (jy in arrayOf(-1, 0, 1))
                if (ir + ix in 0..numRows - 1 && ic + jy in 0..numCols - 1) {
                    if (schema[ir + ix][ic + jy].isDigit()) {
                        adjacentNumbers.add(extractNumber(schema[ir + ix], ic + jy))
                    }
                }
        return adjacentNumbers.toSet()
    }

    fun extractNumber(row: CharArray, iy: Int): adjacentNumber{
        var number = 0
        var ic = iy
        var numberString = ""
        var firstIndex = -1

        while (row[ic].isDigit() && ic > 0) ic--
        if (!(ic == 0 && row[ic].isDigit())) ic++ // go back to first digit
        firstIndex = ic
        while(ic < numCols && row[ic].isDigit() )
            numberString += row[ic++]

        return adjacentNumber(ic, numberString.toInt())
    }

    fun isAdjacent(ir: Int, ic: Int):Boolean{
        for (ix in arrayOf(-1, 0, 1))
            for(jy in arrayOf(-1, 0, 1))
                if (ir + ix in 0..numRows - 1 && ic + jy in 0..numCols - 1)
                    if (isSymbol(schema[ir + ix][ic + jy]))
                        return true
        return false
    }

    fun isSymbol(c: Char): Boolean{
        return !c.isDigit() && c != '.'
    }

    override fun toString(): String {
        var s = ""
        s = schema.joinToString("\n") {it.joinToString(" ") }
        return s
    }

}