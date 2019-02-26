package com.getrhymes.train

class TrainSchedule(val time: String, val  station: String, val  nameTrain: String, val needStation: String,
                     val timeNow: String) {

    private val train = mutableMapOf(
            "L131" to ("12:50" to "Pargolovo"),
            "M132" to ("12:40" to "Viborg"),
            "N133" to ("12:37" to "Finland"),
            "J137" to ("10:49" to "Spb"))

    private val  listStation = mutableMapOf(
            "N137" to mutableListOf("12:37" to "Finland", "14:39" to "London"),
            "L131" to mutableListOf("12:30" to "Pargolovo",  "12:40" to "Viborg"),
            "J139" to mutableListOf("9:49" to "Spb", "7:45" to "Pushkin"))

    private val  nearestTrain = mutableMapOf(
            "Pargolovo" to mutableListOf("15:57" to "L145", "7:45" to "A532", "12:40" to "F413"  ),
            "Spb" to mutableListOf("13:46" to "M156", "12:45" to "K172", "12:57" to "G143"))

    fun addTrain(): MutableMap<String, Pair<String, String>> {
        train[nameTrain] = Pair(time, station)
        var mutMap = mutableMapOf<Int, Pair<String, String>>()
        for ((key, value) in train ) {
            val firstEl = value.first.split(":")
            val firstEl2 = firstEl[0].toInt() * 60 + firstEl[1].toInt()
            mutMap[firstEl2] = Pair(key, value.second)
        }
        mutMap = mutMap.toSortedMap()
        for ((key1, value1) in mutMap) {
            val timeHour = key1 / 60
            val timeMin = key1  % 60
            val resultTime = "$timeHour:$timeMin"
            train[value1.first] = Pair(resultTime, value1.second)
        }
        return train
    }
    fun removeTrain (): MutableMap<String, Pair<String, String>> {
        train.remove(nameTrain)
        return train
    }
    fun addStation (): MutableMap<String, MutableList<Pair<String, String>>> {
        listStation[nameTrain]!!.add(Pair(time, station))
        for ((key, value) in listStation) {
            var remakeMap = mutableMapOf<Int, String>()
            for (el in value) {
                val timeCount = el.first.split(":")
                val timeMinFull = timeCount[0].toInt() * 60 + timeCount[1].toInt()
                remakeMap[timeMinFull] = el.second
            }
            remakeMap = remakeMap.toSortedMap()
            val remakeList = mutableListOf<Pair<String, String>>()
            for ((key2, value2) in remakeMap) {
                val timeHour = key2 / 60
                val timeMin = key2 % 60
                val resultTime = "$timeHour:$timeMin"
                remakeList.add(Pair(resultTime, value2))
            }
            listStation[key] = remakeList
        }
        return listStation
    }
    fun removeStation (): MutableMap<String, MutableList<Pair<String, String>>> {
            listStation[nameTrain]!!.remove(Pair(time, station))
        return listStation
    }
    fun searchTrain (): Pair<String, String> {
        var timeInMin1 = timeNow.split(":")
        val resultTimeNow = timeInMin1[0].toInt() * 60 + timeInMin1[1].toInt()
        val trainAndTime = nearestTrain[needStation]
        var count = 1441
        var needTrain = Pair("", "")
        for (el in trainAndTime!!) {
            timeInMin1 = el.first.split(":")
            val resultTimeNeed =timeInMin1[0].toInt() * 60 + timeInMin1[1].toInt()
            if (resultTimeNeed - resultTimeNow in 1..(count - 1)) {
                count = resultTimeNeed
                needTrain = el
            }
        }
        return needTrain
    }
}






//Хранит расписание поездов для определённой станции отправления.
//// Для каждого поезда хранится конечная станция и список промежуточных.
////
////Методы: добавить новый поезд (название поезда,
//// время отправления, конечная станция), удалить поезд,
//// добавить / удалить промежуточную станцию существующему поезду,
//// поиск ближайшего по времени поезда (по станции, куда едем, и текущему времени).