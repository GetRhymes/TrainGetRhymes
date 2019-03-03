package com.getrhymes.train

fun main(args: Array<String>) {
    val train = Train(nameTrain = "ff4", station = "Myr", time =  "11:48")
    val train3 = Train(nameTrain = "L131", station = "Myr", time =  "11:48")
    val needStation = "Mar"
    val timeNow = "11:30"
    val train2 = TrainSchedule(station = "Kir")
    println(train.addTrain(train.nameTrain, train.station, train.time))
    println()
    println(train.removeTrain(train3.nameTrain))
    println()
    println(train.addStation(train3.nameTrain, train3.station, train3.time))
    println()
    println(train.removeStation(train.station, train.nameTrain))
    println()
    println(train2.searchTrain(timeNow ,needStation, train2.station))
    println()
}