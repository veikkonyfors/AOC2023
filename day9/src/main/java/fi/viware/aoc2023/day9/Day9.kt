package fi.viware.aoc2023.day9

import java.net.URL

class Day9(inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val histories = Histories(inputLines)

    fun solvePuzz1Test(){
        println(histories)
    }

    fun extrapolate(){
        histories.historyList.forEach {
            it.extrapolate()
        }
    }

    fun extrapolateLeft(){
        histories.historyList.forEach {
            it.extrapolateLeft()
        }
    }

    fun solvePuzz1(){
        extrapolate()
        var result = 0
        histories.historyList.forEach {
            var lastInt = it.evalues[0].last()
            result += lastInt
        }
        println(result)
    }

    fun solvePuzz2(){
        extrapolateLeft()
        var result = 0
        histories.historyList.forEach {
            var firstInt = it.evalues[0].first()
            result += firstInt
        }
        println(result)
    }

}