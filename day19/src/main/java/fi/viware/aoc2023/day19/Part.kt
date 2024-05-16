package fi.viware.aoc2023.day19

class Part(line: String) {
    var status: String = "R"
    var workFlows: String = ""
    val rates: MutableList<Pair<String, Int>> = mutableListOf()

    init {
        val rateParts = line.substring(1 until line.length - 1).split(Regex(","))
        rateParts.forEach {
            val (cat, value) = it.split(Regex("="))
            rates.add(Pair(cat,value.toInt()))
        }
    }

    fun addUp(): Int{
        return rates[0].second + rates[1].second + rates[2].second + rates[3].second
    }
    override fun toString(): String {
        val s = rates.toString()
        return s
    }
}