package fi.viware.aoc2023.day16

import java.net.URL

class Day16(val inputFileName: String) {

    val contraption: Contraption
    init {
        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().readLines()
        contraption = Contraption(inputLines)
    }

    fun solvePuzz1(): Int {
        contraption.beam.stepAhead()
        return contraption.countNumberOfEnergizedTilesOnPuzz1()
    }

    fun solvePuzz2(): Int {
        return contraption.getMaxNumberOfEnergizedTiles()
    }
}