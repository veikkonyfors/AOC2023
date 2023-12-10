package fi.viware.aoc2023.day8

class LeftRight(val turnString: String){

    var currentTurn = 0

    fun turn(): Char{

        val ch = turnString[currentTurn++]
        if (currentTurn >= turnString.length) currentTurn = 0

        when (ch){
            'L', 'R' -> {}
            else -> println("JetPattern flaw in pattern: $turnString")
        }

        return ch
    }
}