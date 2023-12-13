package fi.viware.aoc2023.day10

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day10Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day10(){

        val day10 = Day10("raw/input_test")
        //println(day10.field)
        assertEquals(".....\n.S-7.\n.|.|.\n.L-J.\n.....", day10.field.toString())

        var startIndex = day10.field.findStart()
        println(startIndex)
        assertEquals("[(1, 1), (1, 1)]", startIndex.toString())

        var steps = 0
        while ( steps == 0) {
            steps = day10.field.move()
        }

        val r = "${day10.field.currentPoints}\n${day10.field}"
        println(r)
        assertEquals("[(2, 1), (1, 1)]\n.....\n.S-..\n.....\n.....\n.....", r.toString())
        println(steps)
        assertEquals(4, steps)
    }

    @Test
    fun solvePuzz1Test(){
        val day10 = Day10("raw/input_test")
        val r = day10.solvePuzz1()
        println(r)
        assertEquals(4, r)
    }

    @Test
    fun solvePuzz1(){
        val day10 = Day10("raw/input")
        val r = day10.solvePuzz1()
        println(r)
        //println("Moves: ${day10.field.moves}")
        assertEquals(7063, r)
    }

    @Test
    fun main() {
        // Example list of 5 lines, each containing 5 characters
        val lines = listOf(
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "uvwxy"
        )

        // Create a 2D character array and populate it from the lines
        val charArray2D = Array(lines.size) { row ->
            CharArray(lines[row].length) { col ->
                lines[row][col]
            }
        }

        // Access elements in the 2D array
        val element = charArray2D[2][3] // Example: Accessing the element at [2][3]

        // Print the 2D array and an example element
        charArray2D.forEach { row ->
            row.forEach { print("$it ") }
            println()
        }

        println("Element at [2][3]: $element")
    }
}