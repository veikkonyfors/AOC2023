package fi.viware.aoc2023.day8

import org.junit.Assert.*
import org.junit.Test

class Day8Test(){

    @Test
    fun day8(){

        val day8 = Day8("raw/input_test")

        var s = "${day8.inputLines.joinToString(separator = "\n") { it }}"
        //println("s")
        assertEquals("LLR\n\nAAA = (BBB, BBB)\nBBB = (AAA, ZZZ)\nZZZ = (ZZZ, ZZZ)", s)

        val leftRight = LeftRight(day8.inputLines[0])
        s = ""
        for(i in 0..9) s+= leftRight.turn()
        //println(s)
        assertEquals("LLRLLRLLRL", s)

        val nodesLinesStrings = day8.inputLines.subList(2, day8.inputLines.size)
        val nodes = Nodes(nodesLinesStrings)
        s=nodes.toString()
        println(s)
        assertEquals("(AAA, AAA BBB BBB)\n(BBB, BBB AAA ZZZ)\n(ZZZ, ZZZ ZZZ ZZZ)", s)
    }

    @Test
    fun solvePuzz1Test(){
        val day8 = Day8("raw/input_test")
        val n = day8.solvePuzz1()
        println(n)
        assertEquals(6, n)
    }

    @Test
    fun solvePuzz1(){
        val day8 = Day8("raw/input")
        val n = day8.solvePuzz1()
        println(n)
        assertEquals(22411, n)
    }

    @Test
    fun solvePuzz2Test(){
        val day8 = Day8("raw/input_test")
        val n = day8.solvePuzz2()
        println(n)
        assertEquals(22411, n)
    }

}