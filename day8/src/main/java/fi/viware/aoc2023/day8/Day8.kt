package fi.viware.aoc2023.day8

import java.net.URL

class Day8(inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val nodesLinesStrings = inputLines.subList(2, inputLines.size)
    val nodes = Nodes(nodesLinesStrings)
    val leftRight = LeftRight(inputLines[0])

    fun solvePuzz1(): Int{

        var rounds = 0

        var currentNode: Node? = nodes.nodeAndNeighbourMap["AAA"]

        while(currentNode?.home != "ZZZ")
        {
            currentNode = nodes.next(currentNode, leftRight.turn())
            rounds++
        }

        return rounds
    }

    fun solvePuzz2(): Int{

        var rounds = 0

        var currentNode: Node? = nodes.nodeAndNeighbourMap["AAA"]

        while(currentNode?.home != "ZZZ")
        {
            currentNode = nodes.next(currentNode, leftRight.turn())
            rounds++
        }

        return rounds
    }

}