package fi.viware.aoc2023.day8

class Node(val nodeString: String){   //AAA = (BBB, BBB)

    var home: String
    var left: String
    var right: String

    init {
        val regex = Regex("\\s*=\\s*|\\s*[\\(,]\\s*|\\s*[\\),]\\s*")
        val parts = nodeString.split(regex).filter { it.isNotBlank() }
        home = parts[0]
        left = parts[1]
        right = parts[2]
    }

    override fun toString(): String {
        return "$home $left $right"
    }

}