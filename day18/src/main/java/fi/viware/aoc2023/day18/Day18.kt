package fi.viware.aoc2023.day18

import java.io.File
import java.net.URL


fun main(){
    var day18 = Day18("day18/src/main/resources/raw/input_test")
    println("${day18.lagoonPuzz2.volume()}")
    day18 = Day18("day18/src/main/resources/raw/input")
    println("${day18.lagoonPuzz2.volume()}")
}

class Day18(val inputFileName: String) {
    val lagoon: Lagoon
    val lagoonPuzz2: LagoonPuzz2
    init {
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        val inputFile = File(inputFileName)
        val inputLines = inputFile.readLines()
        lagoon = Lagoon(inputLines)
        lagoonPuzz2 = LagoonPuzz2(inputLines)
    }

    fun solvePuzz1(): Int {
        lagoon.dig()
        lagoon.fillSequentially(lagoon.anInteriorPoint)
        return lagoon.countGloryHoles()
    }

    fun solvePuzz2(): Long {
        return lagoonPuzz2.volume()
    }
}

