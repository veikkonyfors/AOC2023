package fi.viware.aoc2023.day3

import java.io.File

class Day3(inputFileName: String) {

    val input = File(inputFileName)
    val inputLines = input.readLines()

    val schematic = Schematic(inputLines)

    fun solve_puzz1():Int{
        val addUp = schematic.addUp()
        return addUp
    }

    fun solve_puzz2():Int{

        val gearRatio = schematic.gearRatio()
        return gearRatio
    }

}