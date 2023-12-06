package fi.viware.aoc2023.day6

class Boat {

    fun sailDistance(pressTime:Long, raceDuration: Long): Long{

        val speed = pressTime
        val retDist = (raceDuration - pressTime)*speed

        return retDist
    }
}