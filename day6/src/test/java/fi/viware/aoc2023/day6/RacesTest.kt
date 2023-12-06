package fi.viware.aoc2023.day6

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class RacesTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun input(){
        val races = Races("Time:      7  15   30\nDistance:  9  40  200".split("\n"))
        println(races)
    }

    @Test
    fun main() {
        val line = "Time:        44     89     96     91"

        // Define a regex pattern to match numbers
        val pattern = Regex("\\b\\d+\\b")

        val regex = "Valve ([\\w]{2}) has flow rate=(\\d+); tunnels? leads? to valves? (.*)".toRegex()

        // Find all matches in the line
        val matches = pattern.findAll(line)

        // Extract the matched numbers and convert them to a list
        val numbers = matches.map { it.value.toInt() }.toList()

        // Print the list of numbers
        println(numbers)
    }
}