package fi.viware.aoc2023.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class GameTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun game(){

        val gameString = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"


        val game = Game(gameString)
        println("$game")

    }
}