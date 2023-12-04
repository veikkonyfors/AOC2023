package fi.viware.aoc2023.day3

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class SchematicTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun schematic(){
        val input = File("input_test")
        val inputLines = input.readLines()

        val schematic = Schematic(inputLines)
        //println("$schematic")
        println("${schematic.addUp()}")
    }

    @Test
    fun sovePuzz1(){
        val day3 = Day3("input")
        val addUp = day3.solve_puzz1()
        println("$addUp")
    }

    /* 2034983 745639 over the line end.
    That's not the right answer; your answer is too high.
    If you're stuck, make sure you're using the full input data; there are also some general tips on the about page,
    or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 3]

    529008 ic numcols - 1
    That's not the right answer; your answer is too low. If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page, or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 3]

    531579
    That's not the right answer; your answer is too high. If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page, or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 3]

    530940
    That's not the right answer. If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page, or you can ask for hints on the subreddit.
    Because you have guessed incorrectly 4 times on this puzzle, please wait 5 minutes before trying again.
    [Return to Day 3]

    530849
     */

    @Test
    fun regex(){

        val inputString = "abc123def"
        val targetDigit = '2'

        val extractedNumber = extractNumberAroundDigit(inputString, targetDigit)

        if (extractedNumber != null) {
            println("The number around '$targetDigit' is: $extractedNumber")
        } else {
            println("No number found around '$targetDigit'")
        }
    }
    fun extractNumberAroundDigit(input: String, targetDigit: Char): Int? {
        val regex = Regex("\\D*(\\d+${Regex.escape(targetDigit.toString())}\\d)\\D*")
        val matchResult = regex.find(input)

        return matchResult?.groupValues?.get(1)?.toIntOrNull()
    }

}