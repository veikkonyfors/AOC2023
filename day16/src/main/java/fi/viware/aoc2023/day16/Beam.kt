package fi.viware.aoc2023.day16

const val RIGHT: Int = 1
const val DOWN: Int = 2
const val LEFT: Int = 3
const val UP: Int = 4

class Beam(val mirrorBox: Array<CharArray>, val visitBox: Array<Array<String>>, var row: Int = 0, var col: Int = 0, var direction: Int = RIGHT ) {

    fun stepAhead(): Boolean{
        var carryOn = false
        when(mirrorBox[row][col]){
            '.' -> if (move())
                stepAhead()
            '|' -> {    if (direction in listOf(RIGHT, LEFT))
                split(UP, DOWN)
                        else if (move()) stepAhead()
            }
            '-' -> {    if (direction in listOf(DOWN, UP))
                split(RIGHT, LEFT)
                        else if (move()) stepAhead()
            }
            '/' -> {    direction = newDirection('/', direction)
                        if (move())
                            stepAhead()
            }
            '\\' -> {   direction = newDirection('\\', direction)
                        if (move())
                            stepAhead()
            }
        }
        return carryOn
    }
    fun split(dir1:Int, dir2: Int){
        direction = dir1
        val newBeam = Beam(mirrorBox, visitBox, row , col, dir2)
        if (move()) stepAhead()
        if (newBeam.move()) newBeam.stepAhead()
    }
    fun move(): Boolean{
        var carryOn = true
        val arrow = when(direction){RIGHT -> '>'; LEFT -> '<'; UP -> '^'; else -> 'v' }
        //println( "${visitBox.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }}\n")
        if (arrow in visitBox[row][col]) return false
        var a = visitBox[row][col]; a += arrow; visitBox[row][col] =a
        when(direction){
            RIGHT -> { if(col >= mirrorBox[0].size - 1) carryOn = false; else col += 1}
            DOWN -> { if(row >= mirrorBox.size - 1) carryOn = false; else row += 1}
            LEFT -> { if(col <= 0) carryOn = false; else col -= 1}
            UP -> { if(row <= 0) carryOn = false; else row -= 1}
        }

        return carryOn
    }

    fun newDirection(tilt: Char, dir: Int): Int{
        var newDir = DOWN
        when(tilt) {
            '/' -> newDir = when (dir) {
                RIGHT -> UP
                DOWN -> LEFT
                LEFT -> DOWN
                else -> RIGHT
            }

            '\\' -> newDir = when(dir){
                RIGHT -> DOWN
                DOWN -> RIGHT
                LEFT -> UP
                else -> LEFT
            }
        }
        return newDir
    }
}