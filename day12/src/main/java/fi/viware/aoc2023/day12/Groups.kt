package fi.viware.aoc2023.day12

class Groups(var input: String) {

    //"1,1,3"

    fun getNumBroken(): Int{
        val l = input.split(',').toTypedArray().map { it.toInt() }.sum()
        return l
    }

    fun toRegex(): Regex{
        val l = input.split(',').toTypedArray().map { it.toInt() }
        var r = "\\.*"
        l.forEachIndexed { index, it ->
            for (i in 0 until it) r += '#'
            if ( index < l.size -1 ) r += "\\.+"
        }
        r += "\\.*"
        return r.toRegex()
    }

    fun extendPuzz2(extention: Int){
        var extendedInput = input
        for (i in 0 until extention ){
            extendedInput += ",$input"
        }

        input = extendedInput
    }

    override fun toString(): String {
        return input
    }
}