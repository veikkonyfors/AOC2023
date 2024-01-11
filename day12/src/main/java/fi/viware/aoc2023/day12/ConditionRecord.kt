package fi.viware.aoc2023.day12

class ConditionRecord(val input: String) {

    var condition: Condition
    var groups: Groups
    var candidateIndexesForBroken: IntArray
    var countHashesToAdd: Int
    var totalSlots: Int
    val cache: MutableMap<String, Int> = mutableMapOf()

    var count = 0

    // ".??..??...?##. 1,1,3"

    init {
        val l = input.split(' ')
        condition = Condition(l[0])
        groups = Groups(l[1])

        // Indices of ?
        candidateIndexesForBroken = condition.getPossiblyBrokenIndices()
        // Count of hash marks to add in place of ?
        countHashesToAdd = getNumBrokenToAddIntoCondition()
        // number of ? on condition
        totalSlots = candidateIndexesForBroken.size
        // Array for building up permutations on hascount hashes into array of totalslots caharacters
        //array = CharArray(totalSlots) { '.' }
    }

    fun getNumBrokenToAddIntoCondition(): Int{
        return groups.getNumBroken() - condition.getNumFixedBroken()
    }
    fun getNumPossibilitiesToAddBroken(): Int{

        var conditionArray: CharArray

        var permutations: MutableList<CharArray> = mutableListOf()
        var conditionsList: MutableList<CharArray> = mutableListOf()

        val array = CharArray(totalSlots) { '.' }

        val numPermutations = 0
        val n = generatePermutations(array, countHashesToAdd, 0, numPermutations)

        return n
    }

    fun generatePermutations(array: CharArray, numberOfHashesStillToAdd: Int, index: Int, numPermutationsSoFar: Int): Int{
        var n = numPermutationsSoFar
        if (numberOfHashesStillToAdd == 0) {
            val conditionArray = condition.input.toCharArray()
            array.forEachIndexed { index, c ->  conditionArray[candidateIndexesForBroken[index]]=c }
            if (isMatch(conditionArray, groups)){
                n += 1
                println(conditionArray)
            }
            return n
        } else {
            for (i in index until array.size) {
                // Try placing a '#' at the current index
                array[i] = '#'
                n =
                    generatePermutations(array, numberOfHashesStillToAdd - 1, i + 1, n)
                // Reset to '.' for backtracking
                array[i] = '.'
            }
            return n
        }
    }

    fun isMatch(condition: CharArray, groups: Groups): Boolean {
        var b = false
        val conditionString = condition.joinToString(separator = "") { it.toString() }
        val groupsRegex = groups.toRegex()

        if (conditionString.matches(groupsRegex)){
            //println("$conditionString, $groupsRegex")
            b = true
        }
        return b
    }

    fun extendPuzz2(extention: Int){
        condition.extendPuzz2(extention)
        groups.extendPuzz2(extention)
        // Indices of ?
        candidateIndexesForBroken = condition.getPossiblyBrokenIndices()
        // Count of hash marks to add in place of ?
        countHashesToAdd = getNumBrokenToAddIntoCondition()
        // number of ? on condition
        totalSlots = candidateIndexesForBroken.size
    }

    override fun toString(): String {
        return "$condition $groups"
    }



}