package fi.viware.aoc2023.day19

class Rule(line: String) { // e.g. "s>3448:a"

    val category: String
    val comp: String
    val value: Int
    val destination: String
    init {
        if (line.contains(':')) {
            val match = Regex("""(.)([<>=])(.*):(.*)""").find(line)
            category = match!!.groupValues[1]
            comp = match!!.groupValues.get(2)
            value = match!!.groupValues.get(3).toInt()
            destination = match!!.groupValues.get(4)
        } else
        {
            category = ""
            comp = ""
            value = -1
            destination = line
        }
    }

    override fun toString(): String {
        return category + comp + when(value) { -1 -> "" else -> value} + destination
    }
}