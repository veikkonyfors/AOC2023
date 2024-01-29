package fi.viware.aoc2023.day13

import java.net.URL

class Day13(inputFileName: String) {

    val patterns: MutableList<Pattern> = mutableListOf()

    init {

        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().useLines { sequence ->
            var patternLines: MutableList<String> = mutableListOf()
            sequence.forEach {
                if (it.isNotBlank())  {
                    patternLines.add(it)
                } else {
                    patterns.add(Pattern(patternLines))
                    patternLines = mutableListOf()
                }
            }
            patterns.add(Pattern(patternLines))
        }

    }

    fun solvePuzz1(): Int{
        var summary = 0
        patterns.forEach { pattern ->
            summary += pattern.summarize()
        }

        return summary
    }
    
}