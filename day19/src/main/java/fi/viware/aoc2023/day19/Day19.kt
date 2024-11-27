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

    fun recurse(workFlowName: String = "in", x: Range, m: Range, a: Range, s: Range): Long {
        var ret = 0L
        val categoryRangeMap = mutableMapOf("x" to x, "m" to m,"a" to a, "s" to s)
        var lastRule: Rule
        for (rule in workFlows[workFlowName]!!.rules) {
            lastRule = rule
            if (rule.category.isNotEmpty()) categoryRangeMap[rule.category]!!.update(rule)
            if (rule.destination in listOf("A", "R")) {
                var toAdd = 1L
                when (rule.destination) {
                    "A" -> categoryRangeMap.values.forEach { toAdd *= it.countAccepted() }
                    else -> toAdd = 0
                }
                ret += toAdd
                val mulStr = categoryRangeMap.values.joinToString(separator = " * ")
                println("$workFlowName: ${rule.toString()} ->  ${rule.destination}: Add ${mulStr} = $toAdd -> $ret")
            } else {
                print("$workFlowName: ${rule.toString()} -> ")
                ret += recurse(
                    rule.destination,
                    categoryRangeMap["x"]!!,
                    categoryRangeMap["m"]!!,
                    categoryRangeMap["a"]!!,
                    categoryRangeMap["s"]!!
                )
            }
            // we go to next rule, as the previous didn't match
            // Previous rule has to be reversed! E.g. x < 10 didn't match, thus x > 9 is true
            if (rule.category.isNotEmpty()) // Final target doesn't have a rule
                categoryRangeMap[rule.category]!!.reverse(rule)
        }
        return ret
    }

    //167409079868000
    //87891312160200
    //72571107160200
    //9719208470400
    //196079140914600
    //93701302754400

    fun solvePuzz2(): Long {
        return 0
    }
}

