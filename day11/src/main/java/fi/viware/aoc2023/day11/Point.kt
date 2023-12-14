package fi.viware.aoc2023.day11

import kotlin.math.abs

data class Point(var x: Int, var y: Int) {

    fun distance(otherPoint: Point): Int{
        return abs(x - otherPoint.x) + abs(y - otherPoint.y)

    }
    override fun toString(): String {
        return "($x, $y)"
    }

}
