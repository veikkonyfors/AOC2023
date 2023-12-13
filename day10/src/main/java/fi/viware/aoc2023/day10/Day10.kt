package fi.viware.aoc2023.day10

import java.net.URL

class Day10(inputFileName: String){

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val field = Field(inputLines)

    fun solvePuzz1(): Int {
        var startIndex = field.findStart()

        var steps = 0
        while ( steps == 0) {
            steps = field.move()
        }
        return steps
    }
}

/*
928
That's not the right answer; your answer is too low. If you're stuck, make sure you're using the full input data;
there are also some general tips on the about page, or you can ask for hints on the subreddit.
Please wait one minute before trying again. [Return to Day 10]
 */