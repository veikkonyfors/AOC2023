package fi.viware.aoc2023.day13

import org.junit.Assert.*
import org.junit.Test

class Day13Test(){

    @Test
    fun Day13(){
        val day13 = Day13("raw/input_test")
        var r = -1

        r = day13.patterns[0].findReflectingRow(1)
        println("$r")
        assertEquals(2,r)

        r = day13.patterns[1].findReflectingRow(1)
        println("$r")
        assertEquals(0,r)

        r = day13.patterns[0].summarize(1)
        println("$r")
        assertEquals(300,r)

        r = day13.patterns[1].summarize(1)
        println("$r")
        assertEquals(100,r)

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

    @Test
    fun solvePuzz2(){
        val day13 = Day13("raw/input")
        var r = day13.solvePuzz2()
        println("$r")
        assertEquals(35691,r)
    }

    /* 25.1.2024
    puzz1
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

    /*
    7.2.2024 Puzz2
    40728
    That's not the right answer; your answer is too high.
    If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page,
    or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 13]

    13528
    That's not the right answer; your answer is too low.
    If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page,
    or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 13]

    12.2.2024
    39037 OK
     */

    @Test
    fun debug(){

        var day13 = Day13("")
        var r = 0

        day13 = Day13("raw/input_test9")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(10,r)

        r = day13.patterns[0].findReflectingColumn(1)
        println("patterns[0].findReflectingColumn $r")
        assertEquals(-1,r)


        day13 = Day13("raw/input_test7")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(-1,r)

        r = day13.patterns[0].findReflectingColumn(1)
        println("patterns[0].findReflectingColumn $r")
        assertEquals(9,r)

        day13 = Day13("raw/input_test1")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(1,r)


        day13 = Day13("raw/input_test4")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(-1,r)

        r = day13.patterns[0].findReflectingColumn(1)
        println("patterns[0].findReflectingColumn $r")
        assertEquals(4,r)

        day13 = Day13("raw/input_test1")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(1,r)

        r = day13.patterns[0].findReflectingColumn(1)
        println("patterns[0].findReflectingColumn $r")
        assertEquals(-1,r)

        day13 = Day13("raw/input_test2")
        r = day13.patterns[0].findReflectingRow(1)
        println("patterns[0].findReflectingRow $r")
        assertEquals(-1,r)

        r = day13.patterns[0].findReflectingColumn(1)
        println("patterns[0].findReflectingColumn $r")
        assertEquals(2,r)

        day13 = Day13("raw/input_test11")
        r = day13.patterns[0].findReflectingRow()
        println("patterns[0].findReflectingRow $r")
        assertEquals(7,r)


        day13 = Day13("raw/input_test3")

        r = day13.patterns[0].findReflectingRow()
        println("patterns[0].findReflectingRow $r")
        assertEquals(-1,r)

        r = day13.patterns[0].findReflectingColumn()
        println("patterns[0].findReflectingColumn $r")
        assertEquals(13,r)


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
        val allowedDiff = 1 // 0 for puzz1, 1 for puzz2
        var sum = 0

        day13.patterns.forEachIndexed { index, pattern ->
            var d = 0

            var r = day13.patterns[index].findReflectingColumn(allowedDiff)
            println("patterns[$index].findReflectingColumn $r")

            if ( r != -1 ) d+=1

            r = day13.patterns[index].findReflectingRow(allowedDiff)
            println("patterns[$index].findReflectingRow $r")

            if ( r != -1 ) d++

            if ( d == 0) println("Both row & column == -1")
            if ( d == 2) println("Both row & column != -1")

            r = day13.patterns[index].summarize(allowedDiff)
            println("patterns[$index].summarize $r")

            sum += r
        }

        println("patterns summarize $sum")

    }




}