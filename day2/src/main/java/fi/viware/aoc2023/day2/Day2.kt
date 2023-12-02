package fi.viware.aoc2023.day2

import java.io.File

class Day2(val inFileName: String) {

    val input = File(inFileName)

    val inputLines = input.readLines()

    fun solvePuzz1(): Int {
        var sum = 0
        inputLines.forEach {
            val game = Game(it)
            if (game.isOk()) sum += game.number
        }
        return sum
    }

    fun solvePuzz2(): Int {
        var sum = 0
        inputLines.forEach {
            val game = Game(it)
            sum += game.getPower()
        }
        return sum
    }
}