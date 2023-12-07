package fi.viware.aoc2023.day7

import java.net.URL

const val FIVES: Int = 7
const val FOURS: Int = 6
const val FULLHOUSE: Int = 5
const val THREES: Int = 4
const val TWOPAIRS: Int = 3
const val PAIR: Int = 2
const val HIGH: Int = 1

class Day7(val inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    fun solvePuzz1(){

        val hands = Hands(inputLines)
        val highestRank = hands.sortedHands.size
        var rank = highestRank
        var totalWin = 0
        hands.sortedHands.forEach {
            println("$it, ${it.bid} * $rank = ${it.bid*rank}")
            totalWin += it.bid*rank--
            println("$totalWin")
        }
        println(totalWin)
    }
}