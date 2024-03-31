package fi.viware.aoc2023.day15

import java.net.URL

class Day15(inputFileName: String) {
    val initialisationSequence: InitialisationSequence

    init {

        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().readLines()
        initialisationSequence = InitialisationSequence(inputLines[0])
    }

    fun solvePuzz1(): Int{
        return 0
    }

    fun solvePuzz2(): Int{

        return 0
    }

}