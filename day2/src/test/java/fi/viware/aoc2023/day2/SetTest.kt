package fi.viware.aoc2023.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class SetTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun generalTest(){
        val string = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        var pattern = Regex("Game (\\d+): ((\\d+ \\w+)(?:, (\\d+ \\w+))*; )*")

       pattern = Regex("^Game (\\d+): (.*)")
        var results = pattern.findAll(string)
        var setsString = ""
        /* results.forEach {
        println("kukkuu")
        println(it!!.groupValues[0])
        println(it!!.groupValues[1])
        println(it!!.groupValues[2])
            setsString = it!!.groupValues[2]
    }*/

        pattern =Regex("(\\d+) ([a-zA-Z]),")
        results = pattern.findAll("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")

        results.forEach {
            println("kukkuu")
            println(it!!.groupValues[0])
            println(it!!.groupValues[1])
            println(it!!.groupValues[2])
            setsString = it!!.groupValues[2]
        }
    }

    /* regex a'la Nibarius
        val regex = "Valve ([\\w]{2}) has flow rate=(\\d+); tunnels? leads? to valves? (.*)".toRegex()
        val (valve, rate, leadTo) = regex.find(line)!!.destructured
        Valve(valve, rate.toInt(), leadTo.split(", "))

        Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
Valve BB has flow rate=13; tunnels lead to valves CC, AA
Valve CC has flow rate=2; tunnels lead to valves DD, BB
Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
Valve EE has flow rate=3; tunnels lead to valves FF, DD
Valve FF has flow rate=0; tunnels lead to valves EE, GG
Valve GG has flow rate=0; tunnels lead to valves FF, HH
Valve HH has flow rate=22; tunnel leads to valve GG
Valve II has flow rate=0; tunnels lead to valves AA, JJ
Valve JJ has flow rate=21; tunnel leads to valve II
     */



}