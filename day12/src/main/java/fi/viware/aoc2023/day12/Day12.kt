package fi.viware.aoc2023.day12

import java.net.URL

class Day12(inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val conditionsRecordList: MutableList<ConditionRecord> = mutableListOf()

    init {
        inputLines.forEach {
            conditionsRecordList.add(ConditionRecord(it))
        }
    }


    fun solvePuzz1():Int{

        var n = 0
        conditionsRecordList.forEach { conditionRecord ->
            n += conditionRecord.getNumPossibilitiesToAddBroken()
        }

        return n
    }
}