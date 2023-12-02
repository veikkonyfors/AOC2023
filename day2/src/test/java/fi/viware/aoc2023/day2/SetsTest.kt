package fi.viware.aoc2023.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class SetsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun sets(){
        val sets = Sets("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        println("$sets")
    }
}