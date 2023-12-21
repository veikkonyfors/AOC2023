package fi.viware.aoc2023.day12

import org.junit.Assert.*
import org.junit.Test


class Day12Test(){

    var day12 = Day12Single("???.### 1,1,3")

    @Test
    fun day121(){

        day12 = Day12Single("???.### 1,1,3")

        //println("$day12")
        assertEquals("???.### 1,1,3", day12.toString())

        var n = day12.conditionRecord.groups.getNumBroken()
        //println("$n")
        assertEquals(5, n)

        val possiblyBrokenIndices = day12.conditionRecord.condition.getPossiblyBrokenIndices()
        val s = possiblyBrokenIndices.joinToString(separator = ", ") { it.toString() }
        //println("$s")
        assertEquals("0, 1, 2", s)

        n = day12.conditionRecord.condition.getNumFixedBroken()
        //println("$n")
        assertEquals(3, n)

        n = day12.conditionRecord.getNumBrokenToAddIntoCondition()
        //println("$n")
        assertEquals(2, n)

        val re = day12.conditionRecord.groups.toRegex()
        println(re)
        assertEquals("\\.*#\\.+#\\.+###\\.*", re.toString())

        n = day12.conditionRecord.getNumPossibilitiesToAddBroken()
        println("$n")
        assertEquals(1, n)
    }

    @Test
    fun day122(){

        day12 = Day12Single(".??..??...?##. 1,1,3")
        //println("$day12")
        assertEquals(".??..??...?##. 1,1,3", day12.toString())

        var n = day12.conditionRecord.groups.getNumBroken()
        //println("$n")
        assertEquals(5, n)

        val possiblyBrokenIndices = day12.conditionRecord.condition.getPossiblyBrokenIndices()
        val s = possiblyBrokenIndices.joinToString(separator = ", ") { it.toString() }
        //println("$s")
        assertEquals("1, 2, 5, 6, 10", s)

        n = day12.conditionRecord.condition.getNumFixedBroken()
        //println("$n")
        assertEquals(2, n)

        n = day12.conditionRecord.getNumBrokenToAddIntoCondition()
        //println("$n")
        assertEquals(3, n)

        val re = day12.conditionRecord.groups.toRegex()
        //println(re)
        assertEquals("\\.*#\\.+#\\.+###\\.*", re.toString())

        n = day12.conditionRecord.getNumPossibilitiesToAddBroken()
        //println("$n")
        assertEquals(4, n)
    }


    @Test
    fun solvePuzz1Test(){
        val day12 = Day12("raw/input_test")
        val n = day12.solvePuzz1()
        println(n)
        assertEquals(21, n)
    }

    @Test
    fun solvePuzz1(){
        val day12 = Day12("raw/input")
        val n = day12.solvePuzz1()
        println(n)
        assertEquals(7705, n)
    }
}