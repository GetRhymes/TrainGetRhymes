package com.getrhymes.train

fun main(args: Array<String>) {

    var newTrain = TrainSchedule(nameTrain = "N137", time = "14:35", station = "Arc", needStation = "Spb",
            timeNow = "13:30")
    println(newTrain.addTrain())
    println(newTrain.removeTrain())
    println(newTrain.addStation())
    println(newTrain.removeStation())
    println(newTrain.searchTrain())

}