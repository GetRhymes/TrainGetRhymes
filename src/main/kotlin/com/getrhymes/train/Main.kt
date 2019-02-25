package com.getrhymes.train

fun main(args: Array<String>) {

    var newTrain = TrainSchedule(nameTrain = "N137", time = "14:35", station = "Arc")
    println(newTrain.addTrain())
    //println(newTrain.removeTrain())
    println(newTrain.addStation())

}