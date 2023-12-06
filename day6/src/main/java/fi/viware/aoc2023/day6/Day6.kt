package fi.viware.aoc2023.day6

import java.io.File

class Day6(inputFileName: String) {

    val input = File(inputFileName)
    val inputLines= input.readLines()

    val races = Races(inputLines)
    val boat = Boat()

    fun solvePuzz1(){


        var result:Int = 1
        races.raceList.forEach {
            val winningResults: MutableList<Int> = mutableListOf()
            for (pressTime in  0..it.time){

                val d = boat.sailDistance(pressTime, it.time)
                if(d > it.distance){
                    winningResults.add(d)
                }
            }
            val numWins = winningResults.size
            println("numWins: $numWins")
            result *= numWins
        }
        println(result)
    }


}