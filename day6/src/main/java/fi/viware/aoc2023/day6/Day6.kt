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
            val winningResults: MutableList<Long> = mutableListOf()
            for (pressTime in  0L..it.time){

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

    fun solvePuzz2_test(){


        var result:Int = 1
            val winningResults: MutableList<Long> = mutableListOf()
            for (pressTime in  0L..71530){

                val d = boat.sailDistance(pressTime, 71530)
                if(d > 940200){
                    winningResults.add(d)
                }
            }
            val numWins = winningResults.size
            println("numWins: $numWins")
            result *= numWins

        println(result)
    }

    fun solvePuzz2(){

        var numWins = 0
        var result:Int = 1
        val winningResults: MutableList<Long> = mutableListOf()
        for (pressTime in  0L..44899691){  // 71530 44899691

            val d = boat.sailDistance(pressTime, 44899691) // 71530 44899691
            if(d > 277113618901768){ // 940200 277113618901768
                //winningResults.add(d)
                numWins +=1

            }
        }
        println("numWins: $numWins")
        result *= numWins

        println(result)
    }


}