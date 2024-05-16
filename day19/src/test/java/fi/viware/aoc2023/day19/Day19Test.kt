package fi.viware.aoc2023.day19

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day19Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day19Puzz1(){
        var day19: Day19
        var s: String
        var i: Int

        day19 = Day19("src/main/res/input_test")
        s = day19.inputLines.joinToString(separator = "\n") { it }
        println("${s}")
        assertEquals("px{a<2006:qkq,m>2090:A,rfg}\npv{a>1716:R,A}\nlnx{m>1548:A,A}\nrfg{s<537:gd,x>2440:R,A}\nqs{s>3448:A,lnx}\nqkq{x<1416:A,crn}\ncrn{x>2662:A,R}\nin{s<1351:px,qqz}\nqqz{s>2770:qs,m<1801:hdj,R}\ngd{a>3333:R,R}\nhdj{m>838:A,pv}\n\n{x=787,m=2655,a=1222,s=2876}\n{x=1679,m=44,a=2067,s=496}\n{x=2036,m=264,a=79,s=2244}\n{x=2461,m=1339,a=466,s=291}\n{x=2127,m=1623,a=2188,s=1013}",s)

        s = day19.workFlows["pv"]!!.name + ": " + day19.workFlows["pv"]!!.rules[0].toString()
        println("$s")
        assertEquals("pv: a>1716R",s)
        s = day19.workFlows["rfg"]!!.name + ": " + day19.workFlows["rfg"]!!.rules[2].toString()
        println("$s")
        assertEquals("rfg: A",s)
        s = day19.workFlows["qqz"]!!.name + ": " + day19.workFlows["qqz"]!!.rules[1].toString()
        println("$s")
        assertEquals("qqz: m<1801hdj",s)

        s = day19.parts.toString()
        println("$s")
        assertEquals("[[(x, 787), (m, 2655), (a, 1222), (s, 2876)], [(x, 1679), (m, 44), (a, 2067), (s, 496)], [(x, 2036), (m, 264), (a, 79), (s, 2244)], [(x, 2461), (m, 1339), (a, 466), (s, 291)], [(x, 2127), (m, 1623), (a, 2188), (s, 1013)]]",s)

        day19.sort()
        s = day19.parts[0].workFlows
        println("$s")
        assertEquals("in -> qqz -> qs -> lnx -> A",s)

        s = day19.parts[3].workFlows
        println("$s")
        assertEquals("in -> px -> qkq -> crn -> R",s)

        i = day19.addUp()
        println("$i")
        assertEquals(19114,i)

    }
}