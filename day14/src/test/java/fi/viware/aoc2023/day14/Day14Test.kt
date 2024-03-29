package fi.viware.aoc2023.day14

import org.junit.Assert.*
import org.junit.Test

class Day14Test(){

    @Test
    fun day14(){

        var s = ""
        var i = 0
        var r:CharArray
        var day14 = Day14("raw/input_test")

        day14 = Day14("raw/input")
        i = day14.solvePuzz2()
        println("$i")
        assertEquals(104533, i)


        day14 = Day14("raw/input_test")
        i = day14.solvePuzz2()
        println("$i")
        assertEquals(64, i)


        //
        day14 = Day14("raw/input_test")
        var round = 0
        var load = 0
        var hash = ""
        val cycleAnalyzer = CycleAnalyzer()
        repeat(1000) {
            hash = day14.platform.oneRound().getHash()
            load = day14.platform.getLoad()
            //println("$round: $load")
            cycleAnalyzer.add(Pair(load, hash), round++)
        }
        //println("$cycleAnalyzer")
        val cycleLength = cycleAnalyzer.getCycleLength()
        println("$cycleLength")
        i=cycleLength
        assertEquals(7,i)
        i = cycleAnalyzer.getGigaLoad()
        println("$i")
        assertEquals(64,i)

        // After three rounds, as described in spec
        day14 = Day14("raw/input_test")
        repeat(3) {
            i = day14.platform.oneRound().getLoad()
            //println("$i\n")
        }
        assertEquals(69,i)

        // $ echo "0 + 5 + 7+1 + 1 + 4+2+1 + 6 + 6+5 + 6+3 + 9+3 + 4+3+2+1" | bc
        //69

        day14 = Day14("raw/input_test")
        day14.platform.tiltNorth()
        i = day14.platform.getLoad()
        println("$i")
        assertEquals(136,i)

        // Go 3 round with original input_test
        day14 = Day14("raw/input_test")
        repeat(3) {
            s = day14.platform.oneRound().toString()
            println("$s\n")
        }
        assertEquals(".....#....\n....#...O#\n.....##...\n..O#......\n.....OOO#.\n.O#...O#.#\n....O#...O\n.......OOO\n#...O###.O\n#.OOO#...O",s)

        // Tilt original input_test north, west, south and east
        day14 = Day14("raw/input_test")
        s = day14.platform.tiltNorth().toString()
        println("$s\n")
        s = day14.platform.tiltWest().toString()
        println("$s\n")
        s = day14.platform.tiltSouth().toString()
        println("$s\n")
        s = day14.platform.tiltEast().toString()
        println("$s\n")
        assertEquals(".....#....\n....#...O#\n...OO##...\n.OO#......\n.....OOO#.\n.O#...O#.#\n....O#....\n......OOOO\n#...O###..\n#..OO#....",s)


        // Tilt original input_test north, west and south
        day14 = Day14("raw/input_test")
        s = day14.platform.tiltNorth().toString()
        s = day14.platform.tiltWest().toString()
        println("$s\n")
        s = day14.platform.tiltSouth().toString()
        println("$s\n")
        assertEquals(".....#....\n....#.O..#\nO..O.##...\nO.O#......\nO.O....O#.\nO.#..O.#.#\nO....#....\nOO....OO..\n#O...###..\n#O..O#....",s)

        // Tilt original input_test first north and then west
        day14 = Day14("raw/input_test")
        s = day14.platform.tiltNorth().toString()
        s = day14.platform.tiltWest().toString()
        println("$s\n")
        assertEquals(
            "OOOO.#O...\nOO..#....#\nOOO..##O..\nO..#OO....\n........#.\n..#....#.#\nO....#OO..\nO.........\n#....###..\n#....#....",s)

        // Tilt original input_test west
        day14 = Day14("raw/input_test")
        s = day14.platform.tiltWest().toString()
        println("$s\n")
        assertEquals(
            "O....#....\n" +
                "OOO.#....#\n.....##...\nOO.#OO....\nOO......#.\nO.#O...#.#\nO....#OO..\nO.........\n#....###..\n#OO..#....",s)

        r = day14.platform.tiltWest(".......O..".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("O.........", s)

        r = day14.platform.tiltWest("..O..#O..O".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("O....#OO..", s)

        r = day14.platform.tiltWest("O.#..O.#.#".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("O.#O...#.#", s)

        r = day14.platform.tiltWest(".O.....O#.".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("OO......#.", s)

        r = day14.platform.tiltWest("OO.#O....O".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("OO.#OO....", s)

        r = day14.platform.tiltWest(".....##...".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals(".....##...", s)

        r = day14.platform.tiltWest("O.OO#....#".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("OOO.#....#", s)

        r = day14.platform.tiltWest("O....#....".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("O....#....", s)

        r = day14.platform.tiltWest("..O.......".toCharArray())
        s = r.joinToString(separator =  "") { it.toString() }
        println("${s}\n")
        assertEquals("O.........", s)

        day14 = Day14("raw/input_test")

        s = day14.platform.tiltNorth().toString()
        println("$s\n")
        assertEquals("OOOO.#.O..\nOO..#....#\nOO..O##..O\nO..#.OO...\n........#.\n..#....#.#\n..O..#.O.O\n..O.......\n#....###..\n#....#....",s)

        s = day14.platform.tiltWest().toString()
        println("$s\n")
        assertEquals("OOOO.#O...\nOO..#....#\nOOO..##O..\nO..#OO....\n........#.\n..#....#.#\nO....#OO..\nO.........\n#....###..\n#....#....",s)

        day14 = Day14("raw/input")
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