package fi.viware.aoc2023.day13

class Pattern(val patternLines: List<String>) {

    fun summarize(allowedDiff: Int = 0): Int{
        val reflectingColumn = findReflectingColumn(allowedDiff)
        var summary = reflectingColumn + 1
        val reflectingRow = findReflectingRow(allowedDiff)
        summary += (reflectingRow + 1) * 100

        return summary
    }

    fun findReflectingColumn(allowedDiff: Int = 0):Int {

        var col = -1

        for (c in 0 .. patternLines[0].length - 1) {
            var d = 0
            var found = false
            var numDistinct = 0

            while (! found) {
                val leftCol = c - d
                val rightCol = c + d + 1
                if (leftCol < 0 || rightCol > patternLines[0].length - 1){
                    found = true
                    break
                }
                val c1 = extractColumn(leftCol)
                val c2 = extractColumn(rightCol)
                if ( ! isReflecting(c1, c2, allowedDiff ) ) { col = -1; break }
                if ( c1 != c2) numDistinct +=1
                col = c
                d++
            }
            if ( numDistinct != allowedDiff) { col = -1; found = false}
            if (found) break
        }

        return col
    }

    fun findReflectingRow(allowedDiff: Int = 0):Int{

        val windowed = patternLines.windowed(2)

        var refRowCandidates = windowed.findReflectingRows {  (r1, r2) -> isReflecting(r1, r2, allowedDiff) }
        var d = 0
        var numDistinct = 0

        var r = -1

        for ( i in refRowCandidates )
        {
            r = i
            d = 0
            var found = false
            numDistinct = if( windowed[i][0] == windowed[i][1])  0 else 1
            while ( !found ) {
                d++
                if (r - d < 0 || r + d + 1 > patternLines.size - 1) {
                    found = true
                    break
                }
                val r1 = patternLines[r + d + 1]
                val r2 = patternLines[r - d]
                if ( ! isReflecting(r1, r2, allowedDiff)) { r = -1; break }
                if ( r1 != r2) numDistinct +=1
            }
            if ( numDistinct != allowedDiff) { r = -1; found = false }
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

    /**
     * Tells if given two consecutive lines can be a reflection point.
     * If lines are the same or have at most numDiff different characters,
     * lines are reflecting.
     */
    fun isReflecting(line1: String, line2: String, numDiff: Int): Boolean{
        if ( line1 == line2 ) return true

        val diffChars = line1.zip(line2).count { (c1, c2) -> c1 != c2 }
        return diffChars == numDiff
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

    fun findReflectingRowPuzz1():Int{

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
}