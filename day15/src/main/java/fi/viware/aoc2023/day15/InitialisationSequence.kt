package fi.viware.aoc2023.day15

class InitialisationSequence(val inputLines: String) {
    val steps: List<String> = inputLines.split(",")  // One line only!

    fun getHash(): Int{
        val hash = steps.sumUp {
            hashOne(it)
        }
        return hash
    }

    // Could have used sumBy, but it seems tobe deprecated
    public inline fun <T> List<T>.sumUp(predicate: (T)  -> Int): Int {
        var sum: Int = 0
        for (element in this) {
            sum += predicate(element)
        }
        return sum
    }

    fun hashOne(step: String): Int{
        val stepList = step.toList()
        var hash = 0
        stepList.forEach {
            hash += it.code
            hash = hash*17%256
        }
        return hash
    }

    public inline fun <T> List<T>.findReflectingRows(predicate: (T) -> Boolean): List<Int> {
        var index = 0
        val indexes = mutableListOf<Int>()
        for (item in this) {
            if (predicate(item)) {
                indexes.add(index)
            }
            index++
        }
        return indexes
    }

    override fun toString(): String {
        return steps.joinToString(separator = "\n") {it}
    }

}