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

        n = galaxies.sumUpDistances()
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
}