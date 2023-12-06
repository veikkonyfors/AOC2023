package fi.viware.aoc2023.day6

class Boat {

    fun sailDistance(pressTime:Int, raceDuration: Int): Int{

        val speed = pressTime
        val retDist = (raceDuration - pressTime)*speed

        return retDist
    }
}