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

    fun solvePuzz2():Int{
        var n = 0
        var i = 0
        conditionsRecordList.forEachIndexed { index, conditionRecord ->
            println("$index: $conditionRecord")
            val unExtendedCount = conditionRecord.getNumPossibilitiesToAddBroken() // Count without extension
            conditionRecord.extendPuzz2(1)
            val extendedByOneCount = conditionRecord.getNumPossibilitiesToAddBroken()/unExtendedCount // Count with extension of 1
            val extendenByFourCount = unExtendedCount*extendedByOneCount*extendedByOneCount*extendedByOneCount*extendedByOneCount
            println("$index: $conditionRecord\n unExtendedCount: $unExtendedCount, extendedByOneCount: $extendedByOneCount, extendenByFourCount: ${extendenByFourCount}")
            n += extendenByFourCount
        }
        return n
    }

    /*
3.1.2023:
    11059467539499415508 / -1206908958
That's not the right answer; your answer is too high. If you're stuck, make sure you're using the full input data;
there are also some general tips on the about page, or you can ask for hints on the subreddit.
Please wait one minute before trying again. [Return to Day 12]

     */


}