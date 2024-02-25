package fi.viware.aoc2023.day14

import org.junit.Assert.*
import org.junit.Test

class Day14Test(){

    @Test
    fun day14(){

        var s = ""
        var i = 0

        var day14 = Day14("raw/input")
        i = day14.solvePuzz1()
        println("$i")
        assertEquals(108813, i)

        day14 = Day14("raw/input_test")
        s = day14.platform.toString()
        println("$s")
        assertEquals("O....#....\nO.OO#....#\n.....##...\nOO.#O....O\n.O.....O#.\nO.#..O.#.#\n..O..#O..O\n.......O..\n#....###..\n#OO..#....",s)

        // echo 10+9+8+7 +10+9+8 +10+4+3 +10 +8 +7 +7 +10+4+8+4 | bc # 136


        i = day14.platform.getLoadNorth()
        println("$i")
        assertEquals(136, i)

        i = day14.platform.getRowLoadNorth(9)
        println("$i")
        assertEquals(11, i)

        i = day14.platform.getRowLoadNorth(3)
        println("$i")
        assertEquals(34, i)

        i = day14.platform.getRowLoadNorth(2)
        println("$i")
        assertEquals(0, i)

        i = day14.platform.getRowLoadNorth(1)
        println("$i")
        assertEquals(29, i)

        i = day14.platform.getRowLoadNorth(0)
        println("$i")
        assertEquals(10, i)

    }
}