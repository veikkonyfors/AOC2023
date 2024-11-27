package fi.viware.aoc2023.day19

class Range {

    var low = 1
    var high = 4000

    constructor() {
        low = 1
        high = 4000
    }

    /* Didn't need in the end
    constructor(rule: Rule): this(){
        when(rule.comp) {
            "<" -> high = rule.value - 1
            else -> low = rule.value + 1
        }
    }*/

    fun update(rule: Rule) {
        when (rule.comp) {
            "<" -> high = minOf(high, rule.value - 1)
            else -> low = maxOf(low, rule.value + 1)
        }
    }

    fun countAccepted(): Long{
        return (high - low + 1).toLong()
    }

    fun reverse(rule: Rule){
        when(rule.comp) {
            "<" -> {
                low = rule.value
                high = 4000
            }
            else ->  {
                low = 1
                high = rule.value
            }
        }
    }
    fun range(): Int{
        return high - low + 1
    }

    override fun toString(): String {
        return "$low - $high"
    }
}