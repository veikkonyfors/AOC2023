package fi.viware.aoc2023.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class SetTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun generalTest(){
        val string = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        var pattern = Regex("Game (\\d+): ((\\d+ \\w+)(?:, (\\d+ \\w+))*; )*")
        val results = pattern.findAll(string)

        results.forEach {
            println("kukkuu")
            println(it!!.groupValues[0])
            println(it!!.groupValues[1])
            println(it!!.groupValues[2])
        }

        pattern = Regex("""\d+\s\w+(?:,\s\d+\s\w+)*""")
        val matches = pattern.findAll(string)

        for (match in matches) {
            println("kotkot")
            println(match.value)
        }

    }
}