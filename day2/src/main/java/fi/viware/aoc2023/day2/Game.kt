package fi.viware.aoc2023.day2

class Game(var gameString: String) {
    var number: Int = 0
    var setsString: String

    var sets:MutableList<Set> = mutableListOf()
    init{
        setsString = ""

        var pattern = Regex("Game (\\d+): (.*)")
        val results = pattern.findAll(gameString)

        results.forEach {
            number = it!!.groupValues[1].toInt()
            setsString = it!!.groupValues[2]
            sets = Sets(setsString).sets
        }
    }

    fun isOk(): Boolean{
        var ok = true

        sets.forEach {
            if (it.blueAmount > 14) {ok =false; return@forEach}
            if (it.greenAmount > 13) {ok =false; return@forEach}
            if (it.redAmount > 12) {ok =false; return@forEach}
        }

        return ok
    }

    fun getPower():Int {
        var power = 0
        var redMin = sets[0].redAmount
        var greenMin = sets[0].greenAmount
        var blueMin = sets[0].blueAmount

        sets.forEach {
            if (it.redAmount > redMin) redMin = it.redAmount
            if (it.greenAmount > greenMin) greenMin = it.greenAmount
            if (it.blueAmount > blueMin) blueMin = it.blueAmount
        }

        return redMin*greenMin*blueMin
    }

    override fun toString(): String {
        var s = ""
        s += "Game $number: $setsString"
        return  s
    }

}