package fi.viware.aoc2023.day8

class Nodes(val inputLines: List<String>) {

    var nodeAndNeighbourMap = mutableMapOf<String, Node>()

    init {
        inputLines.forEach {
            val node = Node(it)
            nodeAndNeighbourMap.put(node.home, node)
        }
    }

    fun next(homeNode:Node?, lr:Char): Node{
        val nodeToReturn:Node? =
        when(lr){
            'L' -> nodeAndNeighbourMap[homeNode?.left]
            else -> nodeAndNeighbourMap[homeNode?.right]
        }
        return nodeToReturn as Node
    }

    override fun toString(): String {
        return nodeAndNeighbourMap.toList().joinToString(separator = "\n") { it.toString() }
    }

}