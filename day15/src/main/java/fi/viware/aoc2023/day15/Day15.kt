package fi.viware.aoc2023.day15

import java.net.URL

class Day15(inputFileName: String) {
    val initialisationSequence: InitialisationSequence
    val boxes = Boxes()

    init {

        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().readLines()
        initialisationSequence = InitialisationSequence(inputLines[0])
    }

    fun solvePuzz1(): Int{
        val day15 = Day15("raw/input")
        return day15.initialisationSequence.getHashSum()
    }

    fun solvePuzz2(): Int{
        val day15 = Day15("raw/input")
        val steps = day15.initialisationSequence.steps
        day15.boxes.processSteps(steps)
        return day15.boxes.getFocusingPower()
    }



}