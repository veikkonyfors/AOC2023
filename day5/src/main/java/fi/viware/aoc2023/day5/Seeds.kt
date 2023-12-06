package fi.viware.aoc2023.day5

class Seeds(val seedsString: String) {

    var currentPairIndex = 0
    var currentRangeIndex = 0

    var firstPair = true

    val seedsList: List<Seed>
    init {
        val regex = "\\d+".toRegex()
        seedsList = regex.findAll(seedsString).map { Seed(it.value.toLong()) }.toList()
    }


    fun getNextOfPairedSeeds(): Seed {

        var seedToReturn = Seed(-1)

        if (currentPairIndex >= seedsList.size) return seedToReturn

        if (firstPair) {
            println("currentPairIndex $currentPairIndex, seedsList[currentPairIndex]: ${seedsList[currentPairIndex]}, Range: ${seedsList[currentPairIndex + 1]}")
            firstPair = false
        }

        seedToReturn = Seed(seedsList[currentPairIndex].number + currentRangeIndex++)

        if (currentRangeIndex >= seedsList[currentPairIndex + 1].number) {
            currentRangeIndex = 0
            currentPairIndex += 2
            firstPair = true
        }

        return seedToReturn
    }

    override fun toString(): String {
        return seedsList.joinToString(separator = ", ") { it.toString() }
    }

}