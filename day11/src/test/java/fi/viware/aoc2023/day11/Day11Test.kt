package fi.viware.aoc2023.day11

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day11Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day11(){

        val day11 = Day11("raw/input_test")
        var s = day11.image.toString()
        //println(s)
        assertEquals("...#......\n.......#..\n#.........\n..........\n......#...\n.#........\n.........#\n..........\n.......#..\n#...#.....", s)

        var n = day11.image.numEmptyRows(day11.image.imageArray)
        //println(n)
        assertEquals(2, n)

        day11.image.imageArray = day11.image.getEnlargedImageRows(day11.image.imageArray)
        s = day11.image.toString()
        //println(s)
        assertEquals("...#......\n.......#..\n#.........\n..........\n..........\n......#...\n.#........\n.........#\n..........\n..........\n.......#..\n#...#.....",s)

        n = day11.image.numEmptyRows(day11.image.imageArray)
        //println(n)
        assertEquals(4, n)

        n = day11.image.numEmptyColumns(day11.image.imageArray)
        //println(n)
        assertEquals(3, n)


        val transposedImage  = day11.image.getTransPosedImageArray(day11.image.imageArray)
        s = transposedImage.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
        //println(s)
        assertEquals("..#........#\n......#.....\n............\n#...........\n...........#\n............\n.....#......\n.#........#.\n............\n.......#....",s)

        day11.image.imageArray = day11.image.getEnlargedImageColumns(day11.image.imageArray)
        s = day11.image.toString()
        //println(s)
        assertEquals(
            "....#........\n.........#...\n#............\n.............\n.............\n........#....\n.#...........\n............#\n.............\n.............\n.........#...\n#....#.......",
            s)

        val galaxies = Galaxies(day11.image)
        s = galaxies.galaxyList.toString()
        //println(s)
        assertEquals("[(0, 4), (1, 9), (2, 0), (5, 8), (6, 1), (7, 12), (10, 9), (11, 0), (11, 5)]", s)

        n = galaxies.galaxyList[4].distance(galaxies.galaxyList[8])
        //println(n)
        assertEquals(9, n)

        n = galaxies.sumUpDistancesPuzz1(galaxies.galaxyList)
        //println(n)
        assertEquals(374, n)

    }

    @Test
    fun solvePuzz1Test(){
        val day11 = Day11("raw/input_test")
        val n = day11.solvePuzz1()
        println(n)
        assertEquals(374, n)
    }

    @Test
    fun solvePuzz1(){
        val day11 = Day11("raw/input")
        val n = day11.solvePuzz1()
        println(n)
        assertEquals(9556712, n)
    }

    @Test
    fun day11Puzz2() {

        val day11 = Day11("raw/input_test")
        var s = day11.image.toString()
        //println(s)
        assertEquals(
            "...#......\n.......#..\n#.........\n..........\n......#...\n.#........\n.........#\n..........\n.......#..\n#...#.....",
            s
        )

        val galaxies = Galaxies(day11.image)
        s = galaxies.galaxyList.toString()

        var n = galaxies.numEmptyRowsBetween(Point(0, 4), Point(2, 0), day11.image.imageArray)
        //println(n)
        assertEquals(0, n)

        n = galaxies.numEmptyRowsBetween(Point(6, 1), Point(9, 4), day11.image.imageArray)
        //println(n)
        assertEquals(1, n)

        n = galaxies.numEmptyColsBetween(Point(0, 0), Point(1, 1))
        //println(n)
        assertEquals(0, n)

        n = galaxies.numEmptyColsBetween(Point(0, 4), Point(1, 7))
        //println(n)
        assertEquals(1, n)

        n = galaxies.numEmptyColsBetween(Point(0, 3), Point(2, 0))
        //println(n)
        assertEquals(1, n)

        var N  = galaxies.sumUpDistancesPuzz22ndtry(galaxies.galaxyList, 1)
        //println(n)
        assertEquals(374, N)

        N = galaxies.sumUpDistancesPuzz22ndtry(galaxies.galaxyList, 9)
        //println(n)
        assertEquals(1030, N)

        N = galaxies.sumUpDistancesPuzz22ndtry(galaxies.galaxyList, 99)
        //println(n)
        assertEquals(8410, N)

        N = galaxies.sumUpDistancesPuzz22ndtry(galaxies.galaxyList, 999999)
        println(n)
        assertEquals(8410, N)
    }

        @Test
    fun debugPuzz1(){
        val day11 = Day11("raw/input_test")
        val image = Image(day11.inputLines)

        // Without any enlargement
        val galaxies0 = Galaxies(image)
        val n0 = galaxies0.sumUpDistancesPuzz1(galaxies0.galaxyList)

        // With enlargement of 1
        val image1 = Image(day11.inputLines)
        val enlargedImageArray = image1.getEnlargedImageColumns(image1.getEnlargedImageRows(image.imageArray))
        image1.imageArray = enlargedImageArray
        val galaxies1 = Galaxies(image1)
        val n1 = galaxies1.sumUpDistancesPuzz1(galaxies1.galaxyList)

        println("distances n=0 $n0, n=1 $n1, n1-n0 = ${n1-n0}")

        val n2 = galaxies0.sumUpDistancesPuzz22ndtry(galaxies0.galaxyList, 1)
        println("$n2")
    }

    /* 82000210 292 + 999999*82

292 + 82
374
292 + 9*82
1030


    That's not the right answer; your answer is too low. If you're stuck, make sure you're using the full input data;
    there are also some general tips on the about page, or you can ask for hints on the subreddit.
    Please wait one minute before trying again. [Return to Day 11]
     */

    @Test
    fun debugPuzz1Tiny(){
        val day11 = Day11("raw/input_tinydbg")
        val image = Image(day11.inputLines)

        // Without any enlargement
        val galaxies0 = Galaxies(image)
        val n0 = galaxies0.sumUpDistancesPuzz1(galaxies0.galaxyList)

        // With enlargement of 1
        val image1 = Image(day11.inputLines)
        val enlargedImageArray = image1.getEnlargedImageColumns(image1.getEnlargedImageRows(image.imageArray))
        image1.imageArray = enlargedImageArray
        val galaxies1 = Galaxies(image1)
        val n1 = galaxies1.sumUpDistancesPuzz1(galaxies1.galaxyList)

        println("distances n=0 $n0, n=1 $n1, n1-n0 = ${n1-n0}")

        val n2 = galaxies0.sumUpDistancesPuzz22ndtry(galaxies0.galaxyList, 1)
        println("$n2")
    }

    @Test
    fun solvePuzz2(){
        val day11 = Day11("raw/input")
        val n = day11.solvePuzz2()
        println(n)
    }
}