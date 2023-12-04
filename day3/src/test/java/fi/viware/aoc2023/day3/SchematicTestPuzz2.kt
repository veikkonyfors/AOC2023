package fi.viware.aoc2023.day3

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class SchematicTestPuzz2 {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun extractNumber(){
        val schema = Schematic(listOf("121......992...............*.......%585....814"))
        val number = schema.extractNumber("121......992...............*.......%585....814".toCharArray(), 11)
        println(number)
    }

    @Test
    fun schematic(){
        val input = File("input_test")
        val inputLines = input.readLines()

        val schematic = Schematic(inputLines)
        //println("$schematic")
        println("${schematic.gearRatio()}")
    }

    @Test
    fun sovePuzz2(){
        val day3 = Day3("input")
        val gearRatio = day3.solve_puzz2()
        println("$gearRatio")
    }

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