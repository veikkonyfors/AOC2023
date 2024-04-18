package fi.viware.aoc2023.day18

class Lagoon(val inputLines: List<String>) {

    val digPlan: MutableList<List<String>> = mutableListOf()

    var dimX = 0
    var dimY = 0
    var startX = 0
    var minX = 0
    var maxX = 0
    var anInteriorPoint = Pair(-1, -1)
    var carryOn = false
    var carryOnPoint = Pair(-1, -1)
    var count = 0

    lateinit var lagoonArray: Array<CharArray>

    init {
        inputLines.forEach{l ->
            digPlan.add(l.split(Regex(" ")))
        }

        val rangeX = rangeX()
        dimX = Math.abs(rangeX.first) + rangeX.second + 1
        dimY = dim("R", "L")
        minX = rangeX.first
        maxX = rangeX.second
        startX = Math.abs(minX)
        if (digPlan[1][0] == "U") anInteriorPoint = Pair(startX +1, 1)
        else anInteriorPoint = Pair(startX + 1, 1)

        lagoonArray = Array(dimX) { row ->
            CharArray(dimY) { col ->
                '.'
            }
        }
    }

    fun countGloryHoles(): Int {
        val n = lagoonArray.sumOf { chars -> chars.count { it in listOf('#', 'O') } }
        return n
    }
    fun fillSequentially(startPoint: Pair<Int,Int>): Int{
        var fill = false
        //var pairlessHash = false

        fun longHash(ir: Int, ic: Int): Boolean{
            return ic > 0 && lagoonArray[ir][ic - 1] == '#'
        }

        fun lastHash(ir: Int, ic: Int): Boolean{
            return !lagoonArray[ir].sliceArray(ic + 1 until lagoonArray[ir].size).any { it == '#' }
        }

        fun fillOrNot(ir: Int, row: CharArray, ic: Int, c: Char){ // c is always '#'
            if (ir > 0 && ir < lagoonArray.size - 1 && ic < dimY - 1){ // On first and last row no fills!
                //pairlessHash = !pairlessHash
                fill = !fill
                // long hash at clear top
                if (longHash(ir, ic) && lagoonArray[ir + 1][ic] == '#' && lagoonArray[ir - 1 ][ic] != 'O') fill = false
                // Long hash at down corner turning up, to fill
                if (longHash(ir, ic) && row[ic+1] == '.' && lagoonArray[ir - 1][ic] == '#'
                    && lagoonArray[ir - 1][ic + 1] == 'O' && !lastHash(ir, ic)) fill = true
                // Long hash at down corner turning down, to fill
                if (longHash(ir, ic) && row[ic+1] == '.' && lagoonArray[ir - 1][ic] == 'O'
                    && lagoonArray[ir - 1][ic + 1] == 'O' && !lastHash(ir, ic)) fill = true
                // Long hash at down corner turning up, no fill
                if (longHash(ir, ic) && row[ic+1] == '.' && lagoonArray[ir - 1][ic] == '#'
                    && lagoonArray[ir - 1][ic + 1] == '.') fill = false
            }
        }

        lagoonArray.forEachIndexed { ir, row ->
            fill = false
            //pairlessHash = false
            row.forEachIndexed { ic, c ->
                when(c){
                    '#' -> if (ic < lagoonArray[0].size - 1 && lagoonArray[ir][ic+1] == '.') fillOrNot(ir, row, ic, c) // Only for the lsat hash in long hash
                    '.' -> {
                        if (fill) lagoonArray[ir][ic] = 'O'}
                }
            }
        }
        return 0
    }

    /**
     * Fills interior recursively starting from startPoint.
     * STACK OVERFLOW for input!
     *
     * Return total number of gloryholes after fill.
     */
    fun fillRecursively(startPoint: Pair<Int,Int>): Int{
        /*if (count > 2000) {
            println("$startPoint, $count")
            carryOn= true;
            carryOnPoint = startPoint;
            return 1
        }
        count += 1

         */
        lagoonArray[startPoint.first][startPoint.second] = '#'
        if(startPoint.second <= 0) return -1
        if (lagoonArray[startPoint.first][startPoint.second + 1] == '.') fillRecursively(Pair(startPoint.first,startPoint.second+1))
        if (lagoonArray[startPoint.first][startPoint.second - 1] == '.') fillRecursively(Pair(startPoint.first,startPoint.second - 1))
        if (lagoonArray[startPoint.first + 1][startPoint.second] == '.') fillRecursively(Pair(startPoint.first + 1,startPoint.second))
        if (lagoonArray[startPoint.first - 1][startPoint.second] == '.') fillRecursively(Pair(startPoint.first - 1,startPoint.second))

        return 0
    }

    /**
     * Count total number of holes
     *
     * DOESN'T WORK
     *
     * We have outline in lagoonArray.
     * Go through it line by line. First outline hole starts counting, second stops it, third starts again, fouth stops etc.
     * NO WORK!
     */
    fun countGloryHolesDontWork(): Int{
        var numGloryHoles = 0
        var count = false
        lagoonArray.forEach { row ->
            row.forEach { col->
                when(col){
                    '#' -> { numGloryHoles++; count = !count}
                    else -> if (count) numGloryHoles++

                }
            }
            println("$numGloryHoles")
        }
        return  numGloryHoles
    }

    /**
     * Returns dimension of the lagoon.
     *
     * If d1 == "R" and d2 == "L", x dimension
     * yf d2 == "U" and d2 == "D", y dimension
     *
     */
    fun dim(d1: String, d2: String): Int{
        var d1Max = 0; var d2Max =0
        var d1N = 0; var d2N = 0
        digPlan.forEach {
            if (it[0] == d1) {
                d1N += it[1].toInt()
                d2N -= it[1].toInt()
            }
            if (it[0] == d2) {
                d1N -= it[1].toInt()
                d2N += it[1].toInt()
            }
            if (Math.abs(d1N) > Math.abs(d1Max)) d1Max = d1N
            if (Math.abs(d2N) > Math.abs(d2Max)) d2Max = d2N
            //println("$d1Max, $d2Max, $d1N, $d2N")
        }
        if (d1Max != -d2Max) return -1
        return Math.abs(d1Max) + 1   // +1 for the initial hole
    }

    fun rangeX(): Pair<Int,Int>{

        var x = 0; var y = 0
        var minX = 0
        var maxX = 0

        digPlan.forEach {
            when ( it[0] ){
                "R"-> for (i in 1..it[1].toInt()) y++
                "L"->  for (i in 1..it[1].toInt()) y--
                "U"-> for (i in 1..it[1].toInt()) x--
                "D"-> for (i in 1..it[1].toInt()) x++
                else -> {}
            }
            //println("$x, $y")
            if (x > maxX) maxX = x
            if (x < minX) minX = x
        }
        //println("$minX, $maxX")
        return  Pair(minX, maxX)
    }
    fun dig(){

        var outSideHoles = 0
        var x = startX; var y = 0

        digPlan.forEach {

            lagoonArray[startX][0] = '#'
            when ( it[0] ){
                "R"-> { for (i in 1..it[1].toInt())
                { lagoonArray[x][++y] = '#' }}
                "L"-> { for (i in 1..it[1].toInt())
                { lagoonArray[x][--y] = '#' }}
                "U"-> { for (i in 1..it[1].toInt())
                { lagoonArray[--x][y] = '#' }}
                "D"-> { for (i in 1..it[1].toInt())
                { lagoonArray[++x][y] = '#' }}
                else -> {}
            }
            //println("$x, $y")
        }
    }

    override fun toString(): String {
        return lagoonArray.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
    }
}