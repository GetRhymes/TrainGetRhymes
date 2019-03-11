package com.getrhymes.train

class TrainSchedule(val station: String) {

    private var schedule = mutableMapOf(
            "L131" to mutableMapOf("Pargolovo" to "12:50", "as" to "13:56", "bi" to "16:10", "vi" to "17:50"),
            "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
            "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
            "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
            "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23"))

      private fun scheduleForStation(station: String): MutableMap<String, MutableMap<String, String>> {
        val haveNeedStation = mutableMapOf<String, MutableMap<String, String>>()
        for ((key, value) in schedule) {
            if (station in schedule[key]!!)
                haveNeedStation[key] = value
        }
        return haveNeedStation
    }

    fun addTrain(train: Train): MutableMap<String, MutableMap<String, String>> {
        schedule[train.nameTrain] = train.listStation
        return schedule
    }

    fun removeTrain(train: Train): MutableMap<String, MutableMap<String, String>> {
        schedule.remove(train.nameTrain)
        return schedule
    }

    fun searchTrain(timeNow: String, needStation: String, stationNow: TrainSchedule): Pair<String, String> {
        val timeInMin1 = timeNow.split(":")
        val resultTimeNow = timeInMin1[0].toInt() * 60 + timeInMin1[1].toInt()
        val needSt = scheduleForStation(stationNow.station)
        var maxTimeValue = 24 * 60 + 1  //максимальное кол-во минут которое может быть
        var countResult = Pair("", 0)
        for ((key, value) in needSt) {
            val timeListDep = value[stationNow.station]!!.split(":")
            val timeInMinDep = timeListDep[0].toInt() * 60 + timeListDep[1].toInt()
            if (needStation in value)
                if (timeInMinDep - resultTimeNow in 1..(maxTimeValue - 1))
                    maxTimeValue = timeInMinDep - resultTimeNow
                    countResult = Pair(key, timeInMinDep)
        }
        val timeInHour = countResult.second / 60
        val timeInMin =  countResult.second % 60
        return Pair(countResult.first,"$timeInHour:$timeInMin")
    }
}





//Хранит расписание поездов для определённой станции отправления.
//// Для каждого поезда хранится конечная станция и список промежуточных.
////
////Методы: добавить новый поезд (название поезда,
//// время отправления, конечная станция), удалить поезд,
//// добавить / удалить промежуточную станцию существующему поезду,
//// поиск ближайшего по времени поезда (по станции, куда едем, и текущему времени).