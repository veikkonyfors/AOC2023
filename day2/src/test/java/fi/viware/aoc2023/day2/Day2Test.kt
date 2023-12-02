package fi.viware.aoc2023.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day2Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun solve_puzz1(){

        val day2 =Day2("input")
        val answer = day2.solvePuzz1()
        println("$answer")
    }

    @Test
    fun solve_puzz2(){

        val day2 =Day2("input")
        val answer = day2.solvePuzz2()
        println("$answer")
    }
}