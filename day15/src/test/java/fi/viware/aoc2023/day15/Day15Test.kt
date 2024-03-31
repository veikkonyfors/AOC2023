package fi.viware.aoc2023.day15

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day15Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day15() {
        var s = ""
        var i = 0

        // Solve Puzz1
        var day15 = Day15("raw/input")
        i = day15.initialisationSequence.getHash()
        println("$i")
        assertEquals(1320,i)

        day15 = Day15("raw/input_test")
        i = day15.initialisationSequence.getHash()
        println("$i")
        assertEquals(1320,i)

        day15 = Day15("raw/HASH")
        i = day15.initialisationSequence.getHash()
        println("$i")
        assertEquals(52,i)

        day15 = Day15("raw/input_test")
        s=day15.initialisationSequence.toString()
        println("${s}")
        assertEquals("rn=1\ncm-\nqp=3\ncm=2\nqp-\npc=4\not=9\nab=5\npc-\npc=6\not=7",s)
    }
}