package fi.viware.aoc2023.day7

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day7Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun solvePuzz1(){
        val day7 = Day7("raw/input")
        val totalWin = day7.solvePuzz1()
        println("$totalWin")
        assertEquals(251806792, totalWin)
    }

    @Test
    fun solvePuzz2(){
        PUZZ2 = true
        val day7 = Day7("raw/input")
        val totalWin = day7.solvePuzz2()
        println("$totalWin")
        assertEquals(252113488, totalWin)
    }
}