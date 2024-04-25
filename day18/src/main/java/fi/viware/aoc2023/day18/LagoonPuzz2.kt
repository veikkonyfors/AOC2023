package fi.viware.aoc2023.day18

import kotlin.math.abs

class LagoonPuzz2(val inputLines: List<String>) {

    val digPlan: MutableList<Pair<Char, Long>> = mutableListOf()
    var dimX = 0
    var dimY = 0
    var startX = 0L
    var minX = 0
    var maxX = 0
    val lagoonOutline: MutableList<Pair<Long, Long>> = mutableListOf()
    //val lagoonMap: Map<Int, List<Int>> // Map of rows, with list of columns on that row

    init{
        //lagoonMap = mutableMapOf()

        inputLines.forEach {
            val hexMatch = Regex("#([0-9a-fA-F]{6})").find(it)
            val hex = hexMatch!!.groupValues.get(1)
            //println("$hex")

            val distance = hex.substring(0,5).toLong(16)
            val intDirToChar = listOf('R', 'D', 'L', 'U')
            val direction = intDirToChar[hex.substring(5,6).toInt()]
            //println("$hex, $distance, $direction")
            digPlan.add(Pair(direction,distance))

        }

        val rangeX = rangeX()
        dimX = Math.abs(rangeX.first) + rangeX.second + 1
        dimY = dim('R', 'L')
        minX = rangeX.first
        maxX = rangeX.second
        startX = Math.abs(minX).toLong()

        var nextPoint = Pair(startX,0L)
        lagoonOutline.add(nextPoint)
        digPlan.forEach {
            nextPoint =
            when(it.first){
                'R'-> Pair(nextPoint.first + it.second, nextPoint.second)
                'D'-> Pair(nextPoint.first, nextPoint.second + it.second)
                'L'-> Pair(nextPoint.first - it.second, nextPoint.second)
                else -> Pair(nextPoint.first, nextPoint.second - it.second)
            }
            lagoonOutline.add(nextPoint)
        }

    }

    fun volume(): Long{
        return shoelaceArea(lagoonOutline) + this.numPointsInOutline(lagoonOutline)/2 + 1
    }

    fun dim(d1: Char, d2: Char): Int{
        var d1Max = 0; var d2Max =0
        var d1N = 0; var d2N = 0
        digPlan.forEach {
            if (it.first == d1) {
                d1N += it.second.toInt()
                d2N -= it.second.toInt()
            }
            if (it.first == d2) {
                d1N -= it.second.toInt()
                d2N += it.second.toInt()
            }
            if (Math.abs(d1N) > Math.abs(d1Max)) d1Max = d1N
            if (Math.abs(d2N) > Math.abs(d2Max)) d2Max = d2N
        }
        if (d1Max != -d2Max) return -1
        return Math.abs(d1Max) + 1   // +1 for the initial hole
    }

    fun rangeX(): Pair<Int,Int>{

        var x = 0; var y = 0
        var minX = 0
        var maxX = 0

        digPlan.forEach {
            when ( it.first ){
                'R'-> for (i in 1..it.second.toInt()) y++
                'L'->  for (i in 1..it.second.toInt()) y--
                'U'-> for (i in 1..it.second.toInt()) x--
                'D'-> for (i in 1..it.second.toInt()) x++
                else -> {}
            }
            //println("$x, $y")
            if (x > maxX) maxX = x
            if (x < minX) minX = x
        }
        //println("$minX, $maxX")
        return  Pair(minX, maxX)
    }

    fun shoelaceArea(outline: List<Pair<Long, Long>>): Long {
        var sum = 0L

        for (i in outline.indices) {
            val prevSum = sum
            sum += outline[i].first * outline[(i + 1) % outline.size].second - outline[(i + 1) % outline.size].first * outline[i].second
        }
        return Math.abs(sum) / 2
    }

    //461937+56407+356671+863240+367720+266681+577262+829975+112010+829975+491645+686074+5411+500254
    //6405262
    fun numPointsInOutline(outline: List<Pair<Long, Long>>): Long{
        var numPoints = 0L
        outline.forEachIndexed { i, pair ->
            numPoints += abs(outline[i].first - outline[(i + 1) % outline.size].first)
            numPoints += abs(outline[i].second - outline[(i + 1) % outline.size].second)
        }
        return numPoints
    }

}