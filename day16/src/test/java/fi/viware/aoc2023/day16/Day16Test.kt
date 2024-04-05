package fi.viware.aoc2023.day16

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day16Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun solevPuzz1(){
        var day16 = Day16("raw/input")
        var i = day16.solvePuzz1()
        println("$i")
        assertEquals(6605,i)

        day16 = Day16("raw/input_test")
        i = day16.solvePuzz1()
        println("$i")
        assertEquals(46,i)
    }

    @Test
    fun day16() {
        var s = ""
        var day16 = Day16("raw/input_test")
        var b = true
        var i = 0

        // Solve puzz1
        day16 = Day16("raw/input_test")
        b = day16.contraption.beam.stepAhead()
        i = day16.contraption.getNumberOfEnergizedTiles()
        println("$i")
        assertEquals(46,i)

        day16 = Day16("raw/input_test")
        b = day16.contraption.beam.stepAhead()
        s = day16.contraption.toString()
        println("$s")
        assertEquals(
            ".|...\\....\n|.-.\\.....\n.....|-...\n........|.\n..........\n.........\\\n..../.\\\\..\n.-.-/..|..\n.|....-|.\\\n..//.|....\n\n" +
                ".>.^v.<.<.<.<....\n..v....^....\n..v....^v.><.>.>.>\n..v....v.^...\n..v....v.^...\n..v....v.^...\n..v...>.>v.v^.<..\n.<.><.>.>.^.v.v.^..\n..^v.<.<.<.v<.><.^v..\n..v....v..v..\n",s)

        val contraption = Contraption(listOf(".|\\.",".-/."))
        contraption.beam.stepAhead()
        s = contraption.toString()
        println("$s")
        assertEquals(".|\\.\n.-/.\n\n.>.^v.<.\n.<.><.^.\n",s)


        day16 = Day16("raw/input_test")
        s = day16.contraption.toString()
        println("$s")
        assertEquals(
            ".|...\\....\n|.-.\\.....\n.....|-...\n........|.\n..........\n.........\\\n..../.\\\\..\n.-.-/..|..\n.|....-|.\\\n..//.|....\n" +
                "\n..........\n..........\n..........\n..........\n..........\n..........\n..........\n..........\n..........\n..........\n",s)
    }
}