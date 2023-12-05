package fi.viware.aoc2023.day5

import java.io.File
class Day5(inputFileName: String) {

    val inputLines: List<String>
    val seeds: List<Seed>

    lateinit var seedToSoilMap: CategoryMap
    lateinit var soilToFertilizerMap: CategoryMap
    lateinit var fertilizerToWaterMap: CategoryMap
    lateinit var waterToLightMap: CategoryMap
    lateinit var lightToTemperatureMap: CategoryMap
    lateinit var temperatureToHumidityMap: CategoryMap
    lateinit var humidityToLocationMap: CategoryMap


    init {
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()

        seeds = Seeds(inputLines[0]).seedsList

        extractMaps()

        println("seedToSoilMap: $seedToSoilMap")
        println("soilToFertilizerMap: $soilToFertilizerMap")
        println("fertilizerToWatermap: $fertilizerToWaterMap")
        println("waterToLightMap: $waterToLightMap")
        println("lightToTemperatureMap: $lightToTemperatureMap")
        println("temperatureToHumidityMap: $temperatureToHumidityMap")
        println("humidityToLocationMap: $humidityToLocationMap")

    }

    fun solvePuzz1(){

        var minLocation = 0L
        seeds.forEach {
            print("seed:$it\n")
            val soil = seedToSoilMap.getTarget(it.number)
            println("soil: $soil")
            val fertilizer = soilToFertilizerMap.getTarget(soil)
            println("fertilizer: $fertilizer")
            val water = fertilizerToWaterMap.getTarget(fertilizer)
            println("water: $water")
            val light = waterToLightMap.getTarget(water)
            println("light: $light")
            val temperature = lightToTemperatureMap.getTarget(light)
            println("temperature: $temperature")
            val humidity = temperatureToHumidityMap.getTarget(temperature)
            println("humidity: $humidity")
            val location = humidityToLocationMap.getTarget(humidity)
            println("location: $location")
            if (location < minLocation || minLocation == 0L) { minLocation = location }
        }

        println("minLocation $minLocation")

    }

    private fun extractMaps() {

        var mapUnderProcessing:CategoryMap = CategoryMap()

        inputLines.forEachIndexed { index, s ->
            if (s.contains("map:")){
                println("$index, $s")
                mapUnderProcessing = CategoryMap()
                when( s ){
                    "seed-to-soil map:" -> seedToSoilMap = mapUnderProcessing
                    "soil-to-fertilizer map:" -> soilToFertilizerMap = mapUnderProcessing
                    "fertilizer-to-water map:" -> fertilizerToWaterMap = mapUnderProcessing
                    "water-to-light map:" -> waterToLightMap = mapUnderProcessing
                    "light-to-temperature map:" -> lightToTemperatureMap = mapUnderProcessing
                    "temperature-to-humidity map:" -> temperatureToHumidityMap = mapUnderProcessing
                    "humidity-to-location map:" -> humidityToLocationMap = mapUnderProcessing
                }
            } else if (s.length != 0 && !s.contains("seeds:")) {
                mapUnderProcessing.add(s)
                //println(mapUnderProcessing)
            }
        }
    }
}