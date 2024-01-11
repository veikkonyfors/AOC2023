package fi.viware.aoc2023.day12

import org.junit.Assert.*
import org.junit.Test


class Day12Test(){

    var day12 = Day12Single("???.### 1,1,3")

    @Test
    fun day12Puzz1TestLine1(){ // Day12 Puzz1 1st test line

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
    fun day12Puzz1TestLine2(){ // Day12 Puzz1 2nd test line

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


    @Test
    fun day12Puzz2TestLine1(){ // Day12 Puzz2 1st test line

        var n: Int


        day12 = Day12Single("???.### 1,1,3")
        day12.conditionRecord.extendPuzz2(4)

        println("$day12")
        assertEquals("???.###????.###????.###????.###????.### 1,1,3,1,1,3,1,1,3,1,1,3,1,1,3", day12.toString())

        n = day12.conditionRecord.groups.getNumBroken()
        //println("$n")
        assertEquals(25, n)

        val possiblyBrokenIndices = day12.conditionRecord.condition.getPossiblyBrokenIndices()
        val s = possiblyBrokenIndices.joinToString(separator = ", ") { it.toString() }
        //println("$s")
        assertEquals("0, 1, 2, 7, 8, 9, 10, 15, 16, 17, 18, 23, 24, 25, 26, 31, 32, 33, 34", s)

        n = day12.conditionRecord.condition.getNumFixedBroken()
        //println("$n")
        assertEquals(15, n)

        n = day12.conditionRecord.getNumBrokenToAddIntoCondition()
        //println("$n")
        assertEquals(10, n)

        val re = day12.conditionRecord.groups.toRegex()
        println(re)
        assertEquals("\\.*#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.*", re.toString())

        n = day12.conditionRecord.getNumPossibilitiesToAddBroken()
        println("$n")
        assertEquals(1, n)
    }

    @Test
    fun day12Puzz2TestLine2(){ // Day12 Puzz2 2nd test line

        day12 = Day12Single(".??..??...?##. 1,1,3")
        day12.conditionRecord.extendPuzz2(4)
        //println("$day12")
        assertEquals(".??..??...?##.?.??..??...?##.?.??..??...?##.?.??..??...?##.?.??..??...?##. 1,1,3,1,1,3,1,1,3,1,1,3,1,1,3", day12.toString())

        var n = day12.conditionRecord.groups.getNumBroken()
        //println("$n")
        assertEquals(25, n)

        val possiblyBrokenIndices = day12.conditionRecord.condition.getPossiblyBrokenIndices()
        val s = possiblyBrokenIndices.joinToString(separator = ", ") { it.toString() }
        //println("$s")
        assertEquals("1, 2, 5, 6, 10, 14, 16, 17, 20, 21, 25, 29, 31, 32, 35, 36, 40, 44, 46, 47, 50, 51, 55, 59, 61, 62, 65, 66, 70", s)

        n = day12.conditionRecord.condition.getNumFixedBroken()
        //println("$n")
        assertEquals(10, n)

        n = day12.conditionRecord.getNumBrokenToAddIntoCondition()
        //println("$n")
        assertEquals(15, n)

        val re = day12.conditionRecord.groups.toRegex()
        //println(re)
        assertEquals("\\.*#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.+#\\.+#\\.+###\\.*", re.toString())

        n = day12.conditionRecord.getNumPossibilitiesToAddBroken()
        //println("$n")
        assertEquals(16384, n)
    }

    @Test
    fun day12Puzz2Line14(){ // Day12 Puzz2 14th line

        day12 = Day12Single("???#???#???#?#?????. 2,9,2")
        val unExtendedCount = day12.conditionRecord.getNumPossibilitiesToAddBroken() // Count without extension
        println("${day12.conditionRecord}\n unExtendedCount: $unExtendedCount")
        day12.conditionRecord.extendPuzz2(1)
        val extendedByOneCount = day12.conditionRecord.getNumPossibilitiesToAddBroken()/unExtendedCount // Count with extension of 1
        val extendenByFourCount = unExtendedCount*extendedByOneCount*extendedByOneCount*extendedByOneCount*extendedByOneCount
        println("${day12.conditionRecord}\n unExtendedCount: $unExtendedCount, extendedByOneCount: $extendedByOneCount, extendenByFourCount: ${extendenByFourCount}")
        assertEquals(16384, extendenByFourCount)
    }


    @Test
    fun solvePuzz2Test(){
        val day12 = Day12("raw/input_test")
        val n = day12.solvePuzz2()
        println(n)
        assertEquals(525152, n)
    }

    @Test
    fun solvePuzz2(){
        val day12 = Day12("raw/input")
        val n = day12.solvePuzz2()
        println(n)
        assertEquals(21, n)
    }

    @Test
    fun main() {
        val array = CharArray(5) { '.' }
        val numberOfHashes = 3
        var numPermutations = 0
        numPermutations = generatePermutations(array, numberOfHashes, 0, numPermutations)
        println("$numPermutations")

        val result = sumIntegers(0, 100)
        println("Sum of integers from 0 to 100: $result")
    }

    fun generatePermutations(array: CharArray, numberOfHashes: Int, index: Int, numPermutationsSoFar: Int): Int{
        var n = numPermutationsSoFar
        if (numberOfHashes == 0) {
            // Print or process the generated permutation
            println(array.joinToString(""))

            return ++n
        } else {
            for (i in index until array.size) {
                // Try placing a '#' at the current index
                array[i] = '#'
                n =
                    generatePermutations(array, numberOfHashes - 1, i + 1, n)
                // Reset to '.' for backtracking
                array[i] = '.'
            }
            return n
        }
    }

    fun sumIntegers(start: Int, end: Int): Int {
        return if (start > end) {
            0 // Base case: If start is greater than end, return 0
        } else {
            start + sumIntegers(start + 1, end) // Recursive case: Add current value and recurse with the next value
        }
    }
}