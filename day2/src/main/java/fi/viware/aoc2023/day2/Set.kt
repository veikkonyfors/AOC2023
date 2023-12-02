package fi.viware.aoc2023.day2

/**
 * One subset of a game.
 * Holds amounts of red, green and blue cubes in the set.
 */
class Set (val setString: String) {
    var redAmount: Int = 0
    var blueAmount: Int = 0
    var greenAmount: Int = 0

    init {
        val balls = setString.split(", ")
        balls.forEach {
            val oneBall = it.split(" ")
            when (oneBall[1]) {
                "red" -> redAmount = oneBall[0].toInt()
                "green" -> greenAmount = oneBall[0].toInt()
                "blue" -> blueAmount = oneBall[0].toInt()
            }
        }
    }

    override fun toString(): String {
        var s = ""
        s += "redAmount: $redAmount, greenAmount: $greenAmount,  blueAmount: $blueAmount;"
        return  s
    }


}