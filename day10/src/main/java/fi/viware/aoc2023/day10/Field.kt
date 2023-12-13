package fi.viware.aoc2023.day10

import kotlin.math.abs

class Field(inputLines:List<String>) {

    val fieldArray = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    val start = findStart()
    var currentPoints = findStart() //mutableListOf(start, start) // Two ways originally, but changed it to one round only. Didn't bother to change this into one point only
    var steps = 0

    val moves =  listOf<MutableList<Pair<Point,Char>>>(mutableListOf(), mutableListOf())

    fun move(): Int{
        steps += 1
        val p = 0
        var end = false

        for(p in 0..0 ) { // In the end go round in one direction and divide by two
            var ch = ' '
            var col = 0;
            var row = 0
            var curChar = fieldArray[currentPoints[p].y][currentPoints[p].x]

            // Down
            col = currentPoints[p].x; row = currentPoints[p].y + 1
            if (curChar in setOf('7', '|', 'F', 'S', '.')) {//continue
                ch = fieldArray[row][col]
                if (ch == 'S') end = true
                if (ch in setOf('|', 'L', 'J')) {
                    if (curChar != 'S') fieldArray[currentPoints[p].y][currentPoints[p].x] = '.';
                    currentPoints[p].y += 1; moves[p].add(Pair(currentPoints[p].copy(), ch));
                    continue
                }
            }

            // Left
            if (curChar in setOf('J', '-', '7', 'S', '.')) { //continue
                ch = fieldArray[currentPoints[p].y][currentPoints[p].x - 1]
                if (ch == 'S') end = true
                if (ch in setOf('-', 'L', 'F')) {
                    if (curChar != 'S') fieldArray[currentPoints[p].y][currentPoints[p].x] = '.';
                    currentPoints[p].x -= 1;
                    moves[p].add(Pair(currentPoints[p].copy(), ch));
                    continue
                }
            }

            // Up
            if (curChar in setOf('L', '|', 'J', 'S', '.')) { //continue
                ch = fieldArray[currentPoints[p].y - 1][currentPoints[p].x]
                if (ch == 'S') end = true
                if (ch in setOf('|', '7', 'F')) {
                    if (curChar != 'S') fieldArray[currentPoints[p].y][currentPoints[p].x] = '.';
                    currentPoints[p].y -= 1;
                    moves[p].add(Pair(currentPoints[p].copy(), ch));
                    continue
                }
            }

            // Right
            if (curChar in setOf('F', '-', 'L', 'S', '.')) { //continue
                col = currentPoints[p].x + 1; row = currentPoints[p].y
                ch = fieldArray[row][col]
                if (ch == 'S') end = true
                if (ch in setOf('-', '7', 'J')) {
                    if (curChar != 'S') fieldArray[currentPoints[p].y][currentPoints[p].x] = '.';
                    currentPoints[p].x += 1; moves[p].add(Pair(currentPoints[p].copy(), ch));
                    continue
                }
            }
        }

        val r = when(end) {
            true -> steps;
            false -> 0}

        return (r + 1) / 2
    }

    fun findStart(): List<Point>{

        lateinit var point: Point

        // Search for the character 'S' in the 2D array
        outer@ for (r in fieldArray.indices) {
            for (c in fieldArray[r].indices) {
                if (fieldArray[r][c] == 'S') {
                    point = Point(c, r)
                    break@outer
                }
            }
        }
        return listOf(point, point.copy())
    }

    override fun toString(): String {
        var s = ""
        s = fieldArray.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
        return s
    }
}