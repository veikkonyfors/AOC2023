package fi.viware.aoc2023.day11

import java.net.URL



class Day11(val inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val image = Image(inputLines)

    /**
     * Enlargenes image by 1 and counts distances
     */
    fun solvePuzz1():Int{
        val enlargedImageArray = image.getEnlargedImageColumns(image.getEnlargedImageRows(image.imageArray))
        image.imageArray = enlargedImageArray

        val galaxies = Galaxies(image)
        val n = galaxies.sumUpDistancesPuzz1(galaxies.galaxyList)
        return n
    }

    /**
     * Makes use of the original image and sums up distances from list of galaxies with adding additional
     * rows and columns in the sum.
     */
    fun solvePuzz2():Long{

        val day11 = Day11("raw/input")

        val galaxies = Galaxies(day11.image)

        val N = galaxies.sumUpDistancesPuzz22ndtry(galaxies.galaxyList, 999999)
        return N
    }

}