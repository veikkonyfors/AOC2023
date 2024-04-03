package fi.viware.aoc2023.day15

class Boxes(val boxes: MutableMap<Int, MutableList<Lens>> = mutableMapOf()) {

    val hashOne: (String) -> Int = InitialisationSequence.Companion::hashOne

    fun getFocusingPower():Int{

        var lensesFocusingPower = 0

        val boxFocusingPower = boxes.entries.sumOf {
            var lensEntry = 1
            lensesFocusingPower = it.value.sumOf { itLens ->
                (lensEntry++)*itLens.focal!!
            }
            (it.key + 1) * lensesFocusingPower
        }

        return boxFocusingPower
    }
    fun processSteps(steps: List<String>){
        //val stepsList = steps.split(Regex(","))
        steps.forEach { processStep(it) }

    }
    fun processStep(step: String) {
        val (label, focal) = step.split(Regex("[=-]"))
        val lens = Lens(label, focal.toIntOrNull())
        val toBox = hashOne(label)
        if (step.contains("=")) add(toBox, lens)
        else remove(toBox, lens)
    }

    fun add(box: Int, lens: Lens) {
        if (boxes.contains(box)) {
            val lensInBox = boxes[box]!!.find { it.label == lens.label }
            if (lensInBox != null) {
                lensInBox.focal = lens.focal
            } else boxes[box]!!.add(lens)
        } else {
            boxes.put(box, mutableListOf(lens))
        }
    }

    fun remove(box: Int, lens: Lens) {
        if (boxes.contains(box)) {
            boxes[box]!!.removeIf {it.label == lens.label}
            if (boxes[box]!!.isEmpty()) boxes.remove(box)
        }
    }

    override fun toString(): String {
        var s=""

        boxes.forEach {
            s += "${it.key}: "
            s += "${it.value.joinToString(separator = "],") { "[${it.label} ${it.focal}"}}]"
            s += "\n"
        }

        return s
    }
}