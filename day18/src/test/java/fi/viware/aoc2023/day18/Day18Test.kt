package fi.viware.aoc2023.day18

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day18Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun solvePuzz1(){
        var day18 = Day18("raw/input_test")
        var i = day18.solvePuzz1()
        println("$i")
        assertEquals(62,i)

        day18 = Day18("raw/input")
        i = day18.solvePuzz1()
        println("$i")
        assertEquals(52231,i)
    }

    @Test
    fun day18(){

        var day18 = Day18("raw/input_test")
        var s = ""
        var i = 0
        var count = 0




        day18 = Day18("raw/input")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}, ${day18.lagoon.anInteriorPoint}"
        println("$s")
        assertEquals("-233, 187, 233, (234, 1)", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("421, 381",s)
        day18.lagoon.dig()
        day18.lagoon.fillSequentially(day18.lagoon.anInteriorPoint)
        i = day18.lagoon.countGloryHoles()
        println("$i")
        assertEquals(62,i)

        day18 = Day18("raw/input_test")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}"
        println("$s")
        assertEquals("0, 9, 0", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("10, 7",s)
        day18.lagoon.dig()
        day18.lagoon.fillSequentially(day18.lagoon.anInteriorPoint)
        s = day18.lagoon.toString()
        println("$s")
        assertEquals("#######\n#OOOOO#\n###OOO#\n..#OOO#\n..#OOO#\n###O###\n#OOO#..\n##OO###\n.#OOOO#\n.######",s)
        i = day18.lagoon.countGloryHoles()
        println("$i")
        assertEquals(62,i)

        day18 = Day18("raw/input")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}, ${day18.lagoon.anInteriorPoint}"
        println("$s")
        assertEquals("-233, 187, 233, (234, 1)", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("421, 381",s)
        day18.lagoon.dig()
        day18.lagoon.fillSequentially(day18.lagoon.anInteriorPoint)
        s = day18.lagoon.toString()
        println("$s")
        //assertEquals("#######\n#######\n#######\n..#####\n..#####\n#######\n#####..\n#######\n.######\n.######",s)

        day18 = Day18("raw/input")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}, ${day18.lagoon.anInteriorPoint}"
        println("$s")
        assertEquals("-233, 187, 233, (234, 1)", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("421, 381",s)
        day18.lagoon.dig()
        // STACK OVERFLOW!!!
        //day18.lagoon.fillRecursively(day18.lagoon.anInteriorPoint)
        while(day18.lagoon.carryOn) {
            day18.lagoon.carryOn = false
            day18.lagoon.count = 0
            println("Carrying on from ${day18.lagoon.carryOnPoint}")
            day18.lagoon.fillRecursively(day18.lagoon.carryOnPoint)
        }
        s = day18.lagoon.toString()
        println("$s")
        //assertEquals("#######\n#######\n#######\n..#####\n..#####\n#######\n#####..\n#######\n.######\n.######",s)

        day18 = Day18("raw/input_test")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}"
        println("$s")
        assertEquals("0, 9, 0", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("10, 7",s)
        day18.lagoon.dig()
        day18.lagoon.fillRecursively(day18.lagoon.anInteriorPoint)
        s = day18.lagoon.toString()
        println("$s")
        assertEquals("#######\n#######\n#######\n..#####\n..#####\n#######\n#####..\n#######\n.######\n.######",s)

        day18 = Day18("raw/input")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}"
        println("$s")
        assertEquals("-233, 187, 233", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("421, 381",s)
        day18.lagoon.dig()
        s = day18.lagoon.toString()
        println("$s")
        //assertEquals("#######\n#.....#\n###...#\n..#...#\n..#...#\n###.###\n#...#..\n##..###\n.#....#\n.######",s)

        day18 = Day18("raw/input_test")
        s = "${day18.lagoon.minX}, ${day18.lagoon.maxX}, ${day18.lagoon.startX}"
        println("$s")
        assertEquals("0, 9, 0", s)
        s = "${day18.lagoon.dimX}, ${day18.lagoon.dimY}"
        println("$s")
        assertEquals("10, 7",s)
        day18.lagoon.dig()
        s = day18.lagoon.toString()
        println("$s")
        assertEquals("#######\n#.....#\n###...#\n..#...#\n..#...#\n###.###\n#...#..\n##..###\n.#....#\n.######",s)

        day18 = Day18("raw/input_test")
        s = day18.lagoon.toString()
        println("$s")
        assertEquals(".......\n.......\n.......\n.......\n.......\n.......\n.......\n.......\n.......\n.......",s)

        day18 = Day18("raw/input_test") // For input 381 x 234
        i = day18.lagoon.dim("R", "L")
        println("$i")
        assertEquals(7,i)
        i = day18.lagoon.dim("U", "D")
        println("$i")
        assertEquals(10,i)


        day18 = Day18("raw/input_test")
        s = day18.lagoon.digPlan.toString()
        println("$s")
        assertEquals("[[R, 6, (#70c710)], [D, 5, (#0dc571)], [L, 2, (#5713f0)], [D, 2, (#d2c081)], [R, 2, (#59c680)], [D, 2, (#411b91)], [L, 5, (#8ceee2)], [U, 2, (#caa173)], [L, 1, (#1b58a2)], [U, 2, (#caa171)], [R, 2, (#7807d2)], [U, 3, (#a77fa3)], [L, 2, (#015232)], [U, 2, (#7a21e3)]]",s)
    }
}