package fi.viware.aoc2023.day19

import java.io.File

class Day19(val inputFileName: String) {
    val workFlows: MutableMap<String, WorkFlow> = mutableMapOf()
    val parts: MutableList<Part> = mutableListOf()
    val inputLines: List<String>

    init {
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()

        inputLines.forEach {
            if (it.length == 0) return@forEach
            when(it[0]){
                '{' -> { parts.add(Part(it))}
                else -> { val wf = WorkFlow(it); workFlows.put(wf.name, wf)}
            }
        }
    }

    fun sort(){
        var workFlowName: String
        for (part in parts) {
           workFlowName = "in"
            part.workFlows = "in"
            //println("$part, $workFlowName")
            while (workFlowName !in listOf("A","R")) {
                workFlowName = apply(workFlows[workFlowName]!!, part)
                part.workFlows += " -> $workFlowName"
            }
            if (workFlowName == "A") part.status = "A"
        }
    }

    fun apply(workFlow: WorkFlow, part: Part): String{
        var wfName = ""
        for (rule in workFlow.rules)
            if (rule.category == "") return rule.destination
            else {
                for (rate in part.rates) {
                    if (rate.first == rule.category) {
                        when(rule.comp){
                            "<" -> {
                                if (rate.second < rule.value) {
                                    wfName = rule.destination
                                    return wfName
                                }
                            }
                            ">" -> {
                                if (rate.second > rule.value) {
                                    wfName = rule.destination
                                    return wfName
                                }
                            }
                        }
                    }
                }
        }
        return wfName
    }

    fun addUp(): Int {
        var sum = 0
        for (part in parts) {
            if (part.status == "A") sum += part.addUp()
        }
        return sum
    }
    fun solvePuzz1(): Int {
        return addUp()
    }

    fun solvePuzz2(): Long {
        return 0
    }
}

