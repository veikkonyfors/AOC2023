package fi.viware.aoc2023.day12

class Condition(var input: String) { // ".??..??...?##.

    fun getPossiblyBrokenIndices(): IntArray {
        return input.indices.filter { input[it] == '?' }.toIntArray()
    }

    fun getNumFixedBroken(): Int {
        return input.indices.filter { input[it] == '#' }.toIntArray().size
    }

    fun extendPuzz2(){
        var extendedI = input
        for (i in 0 until 4){
            extendedI += "?$input"
        }

        input = extendedI
    }

    override fun toString(): String {
        return input
    }
}