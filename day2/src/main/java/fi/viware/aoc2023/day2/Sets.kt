package fi.viware.aoc2023.day2

import kotlin.collections.Set

class Sets(var setsString: String) {
    var sets: MutableList<fi.viware.aoc2023.day2.Set> = mutableListOf()
    init {
        val setStrings = setsString.split("; ")
        setStrings.forEach {
            sets.add(Set(it))
        }
    }

    override fun toString(): String {
        var s = ""
        s += "Sets: $sets"
        return  s
    }


            /*val pattern = Regex("[^;]+")
            val results = pattern.findAll(setsString)

        results.forEach {
            println(it!!.groupValues[0])
            sets.add(Set(it.toString()))
            //println(it!!.groupValues[1])
        }
            //val resultList = matches.map { it.groups[1]?.value ?: "" }.toList()
            //println(resultList)*/

}