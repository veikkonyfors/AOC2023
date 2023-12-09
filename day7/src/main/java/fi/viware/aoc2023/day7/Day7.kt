package fi.viware.aoc2023.day7

import java.net.URL

const val FIVES: Int = 7
const val FOURS: Int = 6
const val FULLHOUSE: Int = 5
const val THREES: Int = 4
const val TWOPAIRS: Int = 3
const val PAIR: Int = 2
const val HIGH: Int = 1
var PUZZ2 = false

class Day7(val inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    fun solvePuzz1(): Int{

        val hands = Hands(inputLines)
        val highestRank = hands.sortedHands.size
        var rank = highestRank
        var totalWin = 0
        hands.sortedHands.forEach {
            //println("$it, ${it.bid} * $rank = ${it.bid*rank}")
            totalWin += it.bid*rank--
            //println("$totalWin")
        }
        //println(totalWin)
        return  totalWin
    }

    fun solvePuzz2(): Int{
        PUZZ2 = true
        val hands = Hands(inputLines)
        val highestRank = hands.sortedHands.size
        var rank = highestRank
        var totalWin = 0
        hands.sortedHands.forEach {
            //println("$it, ${it.bid} * $rank = ${it.bid*rank}")
            totalWin += it.bid*rank--
            //println("$totalWin")
        }
        return totalWin
    }
/*
    That's not the right answer; your answer is too high.
    If you're stuck, make sure you're using the full input data; there are also some general tips on the about page,
    or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 7]
    252306723
    252306723
    252322143
    252113488 OK
 */
}