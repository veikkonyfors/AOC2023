package fi.viware.aoc2023.day14

class CycleAnalyzer {
    var loadRounds: MutableMap<Pair<Int, String>, MutableList<Int>> = mutableMapOf()

    fun add(loadHash: Pair<Int, String>, round: Int){
        if (loadRounds.contains(loadHash)) loadRounds[loadHash]?.add(round)
        else loadRounds.put(loadHash, mutableListOf(round))
    }

    fun getCycleLength(): Int{
        val (key, value) = loadRounds.maxByOrNull { it.value.size } ?: throw NoSuchElementException("No maxByOrNull{it.value.size} in loadRounds")
        val maxRounds = value.size
        //println(" key: $key, maxval: ${maxRounds}")
        val cycleLenght = loadRounds.values.count{ it.size >= maxRounds -1
        }
        return cycleLenght
    }

    fun getGigaLoad(): Int{
        val giga = 1000000000L-1
        val cycleLength = getCycleLength()
        val refRound = (giga - ((giga - 999)/cycleLength+1)*cycleLength).toInt()
        val loadRound = loadRounds.entries.find { refRound in it.value }

        if (loadRound != null) {
            return loadRound.key.first
        }

        return -1
    }

    override fun toString(): String {
        var s = ""
        loadRounds.forEach {
            s += "${it.key}: ${it.value}\n"
        }
        return s
    }
}