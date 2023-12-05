package fi.viware.aoc2023.day5

class Seeds(val seedsString: String) {

    val seedsList: List<Seed>
    init {
        val regex = "\\d+".toRegex()
        seedsList = regex.findAll(seedsString).map { Seed(it.value.toLong()) }.toList()
    }

    override fun toString(): String {
        return seedsList.joinToString(separator = ", ") { it.toString() }
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