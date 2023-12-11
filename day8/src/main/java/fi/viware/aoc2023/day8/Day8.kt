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

    /**
     * Detects, if traversing is in loop for any of the start trails.
     * Returns loopcounts for each trail.
     * Use https://www.calculatorsoup.com/calculators/math/lcm.php to calculate least common multiple,
     * at which round all trails would end with with Z node.
     */
    fun solvePuzz2(): List<Int>{

        var rounds = 0

        val regexKeyEndsWithA = Regex("..A")
        var currentNodesMap: Map<String, Node>? = nodes.nodeAndNeighbourMap.filter { (key, value)  ->
            key.matches(regexKeyEndsWithA)
        }
        //val currentNodesList = currentNodesMap!!.toList().toMutableList()
        val currentNodesKeys = currentNodesMap!!.keys.toList().toMutableList()
        //println("currentNodesKeys: $currentNodesKeys")

        var endsWithZ = false
        var maxZended = 0

        val isInLoop: MutableList<Boolean> = ArrayList(currentNodesKeys.size)
        (0..currentNodesKeys.size - 1).forEach { isInLoop.add(false) }

        val loopCount: MutableList<Int> = ArrayList(currentNodesKeys.size)
        (0..currentNodesKeys.size - 1).forEach { loopCount.add(0) }

        while (!endsWithZ) {
            endsWithZ = true
            val turn = leftRight.turn()
            rounds++
            currentNodesKeys.forEachIndexed { index, key ->
                if(isInLoop[index]) return@forEachIndexed
                var zended = 0
                val nextNode: Node? =
                    when(turn){
                        'L' ->  nodes.nodeAndNeighbourMap[nodes.nodeAndNeighbourMap[key]!!.left] //val nextNode: Node? = nodes.nodeAndNeighbourMap[key]
                        else ->  nodes.nodeAndNeighbourMap[nodes.nodeAndNeighbourMap[key]!!.right]
                    }

                currentNodesKeys[index] = nextNode!!.home
                if (! nextNode!!.home.endsWith('Z')) endsWithZ = false
                else {
                    zended++
                    if (loopCount[index] == 0) { loopCount[index] = rounds }
                    else if ( rounds % loopCount[index] == 0){

                        //loopCount[index] = rounds
                        isInLoop[index] = true
                    }
                }
                //if (zended > maxZended) maxZended = zended
                //if (zended > 2 )println("zended, key: $zended, $key")
            }

            //if (rounds % 50000 == 0)
                //println("Round: $rounds, maxZended: $maxZended ${currentNodesKeys.joinToString(separator = " | ") { it.toString() }}")
//val zLinesCount = (currentNodesKeys.joinToString(separator = " | ") + " |".filter { it == 'Z' }).length
//if(zLinesCount > 5)  println("Round: $rounds, ${currentNodesKeys.joinToString(separator = " | ") { it.toString() }+" |"}")
        }

        //println(loopCount)

        return loopCount

// from here on, use https://www.calculatorsoup.com/calculators/math/lcm.php to calculate LCM pout of these

/*422,217,906,182
        That's not the right answer; your answer is too low. If you're stuck, make sure you're using the full input data;
        there are also some general tips on the about page, or you can ask for hints on the subreddit.
        Please wait one minute before trying again. [Return to Day 8]

        2,164,610,981,777,391,616 2164610981777391616 (minus 1 from each)
        That's not the right answer; your answer is too high. If you're stuck, make sure you're using the full input data;
        there are also some general tips on the about page, or you can ask for hints on the subreddit.
        Please wait one minute before trying again. [Return to Day 8]

        // [16271, 24253, 13201, 14429, 18113, 22411]
// Mine:   16271 24253 13201 14429 18113 22411 11,188,774,513,823
// Original 1stry, wrong, 13201 missing: 24253 26402 14429 18113 22411

 */

    }

    fun solvePuzz22(): Long{

        var rounds = 0L

        val regexKeyEndsWithA = Regex("..A")
        var currentNodesMap: Map<String, Node>? = nodes.nodeAndNeighbourMap.filter { (key, value)  ->
            key.matches(regexKeyEndsWithA)
        }
        //val currentNodesList = currentNodesMap!!.toList().toMutableList()
        val currentNodesKeys = currentNodesMap!!.keys.toList().toMutableList()

        var endsWithZ = false
        var maxZended = 0
        while (!endsWithZ) {
            //println("Round: $rounds, ${currentNodesKeys.joinToString(separator = " | ") { it.toString() }}")
            endsWithZ = true
            val turn = leftRight.turn()
            rounds++
            currentNodesKeys.forEachIndexed { index, key ->
                var zended = 0
                //println("Index, pair: $index, $key")
    val nextNode: Node? =
        when(turn){
            'L' ->  nodes.nodeAndNeighbourMap[nodes.nodeAndNeighbourMap[key]!!.left] //val nextNode: Node? = nodes.nodeAndNeighbourMap[key]
            else ->  nodes.nodeAndNeighbourMap[nodes.nodeAndNeighbourMap[key]!!.right]
        }

    currentNodesKeys[index] = nextNode!!.home
    if (! nextNode!!.home.endsWith('Z')) endsWithZ = false
    else zended++
    if (zended > maxZended) maxZended = zended
    if (zended > 2 )println("zended, key: $zended, $key")
}

if (rounds % 10000000 == 0L) println("Round: $rounds, maxZended: $maxZended ${currentNodesKeys.joinToString(separator = " | ") { it.toString() }}")
//val zLinesCount = (currentNodesKeys.joinToString(separator = " | ") + " |".filter { it == 'Z' }).length
//if(zLinesCount > 5)  println("Round: $rounds, ${currentNodesKeys.joinToString(separator = " | ") { it.toString() }+" |"}")
}

return rounds
}

    fun solvePuzz21(): Int{

        var rounds = 0

        val regexKeyEndsWithA = Regex("..A")
        var currentNodesMap: Map<String, Node>? = nodes.nodeAndNeighbourMap.filter { (key, value)  ->
            key.matches(regexKeyEndsWithA)
        }
        val currentNodesList = currentNodesMap!!.toList().toMutableList()

        var endsWithZ = false

        while (!endsWithZ) {
            println("Round: $rounds, ${currentNodesList.joinToString(separator = " | ") { it.toString() }}")
            endsWithZ = true
            val turn = leftRight.turn()
            rounds++
            currentNodesList.forEachIndexed { index, pair ->
                var zended = 0
                println("Index, pair: $index, $pair")
                val nextNode = nodes.next(pair.second, turn)
                currentNodesList[index] = Pair(nextNode.home, nextNode)
                if (! nextNode.home.endsWith('Z')) endsWithZ = false
                else zended++
                println("Index, pair, zended: $index, $pair, $zended")
            }
        }

        return rounds

    }


}