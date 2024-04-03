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
        var day15 = Day15("raw/input_test")
        val hashOne: (String)-> Int = InitialisationSequence.Companion::hashOne
        var steps = listOf<String>()

        // Solve Puzz2
        day15 = Day15("raw/input")
        i=day15.solvePuzz2()
        assertEquals(239484, i)


        day15 = Day15("raw/input")
        steps = day15.initialisationSequence.steps
        day15.boxes.processSteps(steps)
        i = day15.boxes.getFocusingPower()
        println("${i}")
        assertEquals(239484, i)

        day15 = Day15("raw/input_test")
        steps = day15.initialisationSequence.steps
        day15.boxes.processSteps(steps)
        i = day15.boxes.getFocusingPower()
        println("${i}")
        assertEquals(145, i)

        day15 = Day15("raw/input_test")
        steps = day15.initialisationSequence.steps
        day15.boxes.processSteps(steps)
        s = day15.boxes.toString()
        println("${s}")
        assertEquals("0: [rn 1],[cm 2]\n3: [ot 7],[ab 5],[pc 6]\n", s)

        day15 = Day15("raw/input_test")
        val step = day15.initialisationSequence.steps[0]
        assertEquals("rn=1",step)
        day15.boxes.processStep(step)
        s = day15.boxes.toString()
        println("${s}")
        assertEquals("0: [rn 1]\n", s)

        // Solve Puzz1
        day15 = Day15("raw/input")
        i = day15.initialisationSequence.getHashSum()
        assertEquals(511257,i)

        day15 = Day15("raw/input")
        i = day15.initialisationSequence.getHashSum()
        println("$i")
        assertEquals(511257,i)

        day15 = Day15("raw/input_test")
        i = day15.initialisationSequence.getHashSum()
        println("$i")
        assertEquals(1320,i)

        day15 = Day15("raw/HASH")
        i = day15.initialisationSequence.getHashSum()
        println("$i")
        assertEquals(52,i)

        day15 = Day15("raw/input_test")
        s=day15.initialisationSequence.toString()
        println("${s}")
        assertEquals("rn=1\ncm-\nqp=3\ncm=2\nqp-\npc=4\not=9\nab=5\npc-\npc=6\not=7",s)
    }
}