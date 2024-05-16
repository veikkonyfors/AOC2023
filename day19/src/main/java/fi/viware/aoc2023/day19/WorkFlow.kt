package fi.viware.aoc2023.day19

class WorkFlow(line: String) {
    val name: String
    val rulesString: String
    val rules: MutableList<Rule> = mutableListOf()

    init {
        //val match = Regex("#([0-9a-fA-F]{6})").find(it)
        val match = Regex("""(.*)\{(.*)\}""").find(line)
        name = match!!.groupValues.get(1)
        rulesString = match!!.groupValues.get(2)
        val ruleParts = rulesString.split(Regex(","))
        ruleParts.forEach {
            rules.add(Rule(it))
        }
    }

    override fun toString(): String {
        return "$name: $rulesString"
    }

}