package fi.viware.aoc2023.day18

import java.net.URL

class Day18(val inputFileName: String) {
    val lagoon: Lagoon
    init {
        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().readLines()
        lagoon = Lagoon(inputLines)
    }

    fun solvePuzz1(): Int {
        lagoon.dig()
        lagoon.fillSequentially(lagoon.anInteriorPoint)
        return lagoon.countGloryHoles()
    }

    fun solvePuzz2(): Int {
        return 0
    }
}