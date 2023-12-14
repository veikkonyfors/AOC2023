package fi.viware.aoc2023.day11

import kotlin.math.abs


class Galaxies(imageOfGalaxies: Image) {

    val galaxyList = mutableListOf<Point>()

    init {
        for (row in 0 until imageOfGalaxies.imageArray.size) {
            for (col in 0 until imageOfGalaxies.imageArray[0].size) {
                if (imageOfGalaxies.imageArray[row][col] == '#') galaxyList.add(Point(row, col))
            }
        }
    }

    fun sumUpDistances(): Int{
        var sumDistances = 0
        galaxyList.forEach { p1 ->
            galaxyList.forEach {p2 ->
                sumDistances += p1.distance(p2)
            }
        }
        return sumDistances/2
    }


    override fun toString(): String {
        return galaxyList.joinToString(separator = ", ") { it.toString() }
    }

}