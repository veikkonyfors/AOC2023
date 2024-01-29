package fi.viware.aoc2023.day13

class Pattern(val patternLines: List<String>) {

    val height = patternLines.size
    val width = patternLines[0].length

    var patternArray = Array(patternLines.size) { row ->
        CharArray(patternLines[row].length) { col ->
            patternLines[row][col]
        }
    }

    fun summarize(): Int{
        val reflectingColumn = findReflectingColumn()
        var summary = reflectingColumn + 1
        val reflectingRow = findReflectingRow()
        summary += (reflectingRow + 1) * 100

        return summary
    }

    fun findReflectingColumn():Int {

        var col = -1

        for (c in 0 .. patternLines[0].length - 1) {
            var d = 0
            var found = false

            while (! found) {
                val leftCol = c - d
                val rightCol = c + d + 1
                if (leftCol < 0 || rightCol > patternLines[0].length - 1){
                    found = true
                    break
                }
                val c1 = extractColumn(leftCol)
                val c2 = extractColumn(rightCol)
                if (c1 != c2 ) { col = -1; break }
                col = c
                d++
            }

            if (found) break
        }

        return col
    }

    fun findReflectingRow():Int{

        val windowed = patternLines.windowed(2)

        var refRowCandidates = windowed.findReflectingRows {  (r1, r2) -> r1 == r2 }
        var d = 0

        var r = -1

        for ( i in refRowCandidates )
        {
            r = i
            var found = false
            while ( !found ) {
                d++
                if (r - d < 0 || r + d + 1 > patternLines.size - 1) {
                    found = true
                    break
                }
                val r1 = patternLines[r + d + 1]
                val r2 = patternLines[r - d]
                if (r1 != r2) {
                    r = -1; break
                }
            }

            if (found) break
        }
        return r
    }

    public inline fun <T> List<T>.findReflectingRows(predicate: (T) -> Boolean): List<Int> {
        var index = 0
        val indexes = mutableListOf<Int>()
        for (item in this) {
            if (predicate(item)) {
                indexes.add(index)
            }
                index++
        }
        return indexes
    }

    public inline fun <T> List<T>.findReflectingRows2(predicate: (T) -> Boolean): Int {
        var index = 0
        for (item in this) {
            if (predicate(item))
                return index
            index++
        }
        return -1
    }



    fun extractColumn(col: Int): String {

        val s = patternLines.map { row ->
            row.getOrNull(col) ?: ""
        }.joinToString(separator = "")

        return s
    }

    override fun toString(): String {
        return patternLines.joinToString(separator = "\n") { it }
    }



    // Fails to find mirror if mirroring column is not the first of adjacent identical columns
    // I.e. later right there is another one that fulfills reflection
    fun findReflectingColumnIndexOfFirst():Int {

        var c = (0 until patternLines[0].length - 1)
            .map { sarake ->
                patternLines.map { rivi -> rivi[sarake] to rivi[sarake + 1] }
            }
            .indexOfFirst { sarakepari ->
                sarakepari.all { (ensimmainen, toinen) -> ensimmainen == toinen }
            }

        var d = 0
        while (true) {
            d++
            if (c - d < 0 || c + d + 1 > patternLines[0].length - 1) break
            val c1 = extractColumn(c + d + 1)
            val c2 = extractColumn(c - d)
            if (c1 != c2 ) { c = -1; break }
        }

        return c
    }

    fun findReflectingRowIndexOfFirst():Int{

        //val mapped = patternArray.map { it.toList() }
        val windowed = patternLines.windowed(2)

        var r = windowed.indexOfFirst {  (r1, r2) -> r1 == r2 }
        var d = 0

        while (true) {
            d++
            if (r - d < 0 || r + d + 1 > patternLines.size - 1) break
            val r1 = patternLines[r + d + 1]
            val r2 = patternLines[r - d]
            if (r1 != r2 ) { r = -1; break }
        }

        return r
    }
}