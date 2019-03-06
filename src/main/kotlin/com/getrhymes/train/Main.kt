package com.getrhymes.train

fun main(args: Array<String>) {
    val train = Train(nameTrain = "ff4", station = "Myr", time =  "11:48", listStation = mutableMapOf("Myr" to "11:48"))
    val train3 = Train(nameTrain = "L131", station = "Pargolovo", time =  "11:48",
            listStation = mutableMapOf("Myr" to "11:48"))
    val needStation = "Mar"
    val timeNow = "11:30"
    val train2 = TrainSchedule(station = "Kir")
    println(train2.addTrain(train.nameTrain, train.listStation))
    println()
    println(train2.removeTrain(train3.nameTrain))
    println()
    println(train.addStation(train3.station, train3.time))
    println()
    println(train.removeStation(train.station))
    println()
    println(train2.searchTrain(timeNow ,needStation, train2.station))
    println()
}