package fi.viware.aoc2023.day13

import org.junit.Assert.*
import org.junit.Test

class Day13Test(){

    @Test
    fun Day13(){
        val day13 = Day13("raw/input_test")
        var r = -1

        var s = day13.patterns.joinToString(separator = "\n\n")
        println("${s}")
        assertEquals(
        "#.##..##.\n..#.##.#.\n##......#\n##......#\n..#.##.#.\n..##..##.\n#.#.##.#.\n\n#...##..#\n#....#..#\n..##..###\n#####.##.\n#####.##.\n..##..###\n#....#..#",
            s)

        s = day13.patterns[0].extractColumn(2)
        println("$s")
        assertEquals("##..###",s)

        r = day13.patterns[0].findReflectingColumn()
        println("$r")
        assertEquals(4,r)

        r = day13.patterns[0].findReflectingRow()
        println("$r")
        assertEquals(-1,r)

        r = day13.patterns[0].summarize()
        println("$r")
        assertEquals(5,r)

        r = day13.patterns[1].findReflectingColumn()
        println("$r")
        assertEquals(-1,r)

        r = day13.patterns[1].findReflectingRow()
        println("$r")
        assertEquals(3,r)

        r = day13.patterns[1].summarize()
        println("$r")
        assertEquals(400,r)

        r = day13.solvePuzz1()
        println("$r")
        assertEquals(405,r)

    }

    @Test
    fun solvePuzz1(){
        val day13 = Day13("raw/input")
        var r = day13.solvePuzz1()
        println("$r")
        assertEquals(35691,r)
    }

    /* 25.1.2024
30488
That's not the right answer; your answer is too low. If you're stuck, make sure you're using the full input data;
there are also some general tips on the about page,
or you can ask for hints on the subreddit. Please wait one minute before trying again. [Return to Day 13]
findreflectingcolumns fixed not to stop on first mirror candidate
That's not the right answer; your answer is too low. If you're stuck,
make sure you're using the full input data; there are also some general tips on the about page,
or you can ask for hints on the subreddit.
Please wait one minute before trying again. [Return to Day 13]

26.1.2023
31190
findreflectingcolumns stopped on first reflecting row pair.
Fixed that => 35691 OK


 */

    @Test
    fun debug(){
        var day13 = Day13("raw/input_test11")
        var r = day13.patterns[0].findReflectingRow()
        println("patterns[0].findReflectingRow $r")
        assertEquals(7,r)


        day13 = Day13("raw/input_test2")

        r = day13.patterns[0].findReflectingColumn()
        println("patterns[0].findReflectingColumn $r")
        assertEquals(13,r)

        r = day13.patterns[0].findReflectingRow()
        println("patterns[0].findReflectingRow $r")

        r = day13.patterns[0].summarize()
        println("$r")
        assertEquals(14,r)

        var s = day13.patterns[0].extractColumn(2)
        println("$s")
        assertEquals("..##..#.###",s)


    }

    @Test
    fun debugAll(){
        val day13 = Day13("raw/input")

        day13.patterns.forEachIndexed { index, pattern ->
            var r = day13.patterns[index].findReflectingColumn()
            println("patterns[$index].findReflectingColumn $r")

            r = day13.patterns[index].findReflectingRow()
            println("patterns[$index].findReflectingRow $r")

            r = day13.patterns[index].summarize()
            println("patterns[$index].summarize $r")
        }
    }



}