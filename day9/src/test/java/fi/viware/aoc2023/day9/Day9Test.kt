package fi.viware.aoc2023.day9

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day9Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day9(){
        val day9 = Day9("raw/input_test")
        println(day9.histories)
        assertEquals("0 3 6 9 12 15\n1 3 6 10 15 21\n10 13 16 21 30 45", day9.histories.toString())

        day9.extrapolate()
        var historyLists= ""
        day9.histories.historyList.forEach {
            historyLists += it.evalues.toString() + "\n"
        }
        println(historyLists)
        assertEquals("[[0, 3, 6, 9, 12, 15, 18], [3, 3, 3, 3, 3, 3], [0, 0, 0, 0, 0, 0]]\n" +
                "[[1, 3, 6, 10, 15, 21, 28], [2, 3, 4, 5, 6, 7], [1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0]]\n" +
                "[[10, 13, 16, 21, 30, 45, 68], [3, 3, 5, 9, 15, 23], [0, 2, 4, 6, 8], [2, 2, 2, 2], [0, 0, 0, 0, 0, 0]]\n"
        ,historyLists.toString())

        var result = 0
        day9.histories.historyList.forEach {
            var lastInt = it.evalues[0].last()
            result += lastInt
        }
        println(result)
        assertEquals(114, result)

    }

    @Test
    fun solvePuzz1Test(){
        val day9 = Day9("raw/input_test")
        day9.solvePuzz1()
    }

    @Test
    fun solvePuzz1(){
        val day9 = Day9("raw/input")
        day9.solvePuzz1()
    }
}