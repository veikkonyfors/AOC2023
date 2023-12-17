package fi.viware.aoc2023.day11


class Galaxies(val imageOfGalaxies: Image) {

    var galaxyList = mutableListOf<Point>()

    init {
        galaxyList = getGalaxyPointList()
    }

    fun sumUpDistancesPuzz1(galaxyList: MutableList<Point>): Int{
        var sumDistances = 0
        galaxyList.forEach { p1 ->
            galaxyList.forEach {p2 ->
                sumDistances += p1.distance(p2)
            }
        }
        return sumDistances/2
    }

    // Makes use of enlargened array from Puzz1. Does not work properly
    fun sumUpDistancesPuzz21stry(galaxyList: MutableList<Point>, emptyLargerByPowerOfTens: Int): Int{
        var sumDistances = 0
        galaxyList.forEach { p1 ->
            galaxyList.forEach {p2 ->
                val numEmptyRowsOrg = numEmptyRowsBetween(p1, p2, imageOfGalaxies.imageArray)/2 // We already have enlargened space (by 1) -> /2
                val numEmptyColsOrg = numEmptyColsBetween(p1, p2)/2
                val numEmptyRowsPowered = numEmptyRowsOrg*(Math.pow(10.0, emptyLargerByPowerOfTens.toDouble()).toInt() -2) // We already have enlargened space (by 1)
                val numEmptyCols2Powered = numEmptyColsOrg*(Math.pow(10.0, emptyLargerByPowerOfTens.toDouble()).toInt() - 2)
                val distanceOrg = p1.distance(p2)
                sumDistances += (distanceOrg
                        + numEmptyRowsPowered
                        + numEmptyCols2Powered)
                println("p1, $p1, p2, $p2 numEmptyRowsOrg, $numEmptyRowsOrg, numEmptyColsOrg, $numEmptyColsOrg, sumDistances, $sumDistances, " +
                        "numEmptyRowsPowered, $numEmptyRowsPowered, numEmptyCols2Powered, $numEmptyCols2Powered, distanceOrg, $distanceOrg: ")
            }
        }
        return sumDistances/2
    }

    // Makes use of th eoriginal image array. Adds up appropriate number of steps: 10, hundred or even million. Minus one of course.
    fun sumUpDistancesPuzz22ndtry(galaxyList: MutableList<Point>, addedEmptyLinesOrColumns: Int): Long{
        var sumDistances = 0L
        galaxyList.forEach { p1 ->
            galaxyList.forEach {p2 ->
                val numEmptyRowsOrg = numEmptyRowsBetween(p1, p2, imageOfGalaxies.imageArrayOriginal)
                val numEmptyColsOrg = numEmptyColsBetween(p1, p2)
                val numEmptyRowsPowered = numEmptyRowsOrg*addedEmptyLinesOrColumns
                val numEmptyCols2Powered = numEmptyColsOrg*addedEmptyLinesOrColumns
                val distanceOrg = p1.distance(p2)
                sumDistances += (distanceOrg
                        + numEmptyRowsPowered
                        + numEmptyCols2Powered
                        )
                //println("p1, $p1, p2, $p2 numEmptyRowsOrg, $numEmptyRowsOrg, numEmptyColsOrg, $numEmptyColsOrg, sumDistances, $sumDistances, " +
                //        "numEmptyRowsPowered, $numEmptyRowsPowered, numEmptyCols2Powered, $numEmptyCols2Powered, distanceOrg, $distanceOrg: ")
            }
        }
        return sumDistances/2
    }

    fun numEmptyRowsBetween(point1:Point, point2: Point, imageArray: Array<CharArray>): Int{
        var emptyRows = 0

        val x1 = Math.min(point1.x, point2.x)
        val x2 = Math.max(point1.x, point2.x)

        for (row in x1 + 1 until x2) {
            if (imageOfGalaxies.isEmpty(imageArray[row])) emptyRows++
        }
        return emptyRows
    }

    fun numEmptyColsBetween(point1:Point, point2: Point): Int{
        val transposedArray = imageOfGalaxies.getTransPosedImageArray(imageOfGalaxies.imageArray)
        var transposedPoint1 = Point(point1.y, point1.x)
        var transposedPoint2 = Point(point2.y, point2.x)
        val galaxyList = getGalaxyPointList()
        if (transposedPoint1.x > transposedPoint2.x) { val tmpPoint = transposedPoint1;  transposedPoint1 = transposedPoint2; transposedPoint2 = tmpPoint}  // Need to swap
        var emptyCols = numEmptyRowsBetween(transposedPoint1,transposedPoint2,transposedArray)
        return emptyCols
    }

    fun getGalaxyPointList(): MutableList<Point>{
        val galaxyPointList = mutableListOf<Point>()
        for (row in 0 until imageOfGalaxies.imageArray.size) {
            for (col in 0 until imageOfGalaxies.imageArray[0].size) {
                if (imageOfGalaxies.imageArray[row][col] == '#') galaxyPointList.add(Point(row, col))
            }
        }
        return galaxyPointList
    }

    override fun toString(): String {
        return galaxyList.joinToString(separator = ", ") { it.toString() }
    }

}