package com.getrhymes.train

class Train (val nameTrain: String, val station: String, val time: String ) {

    private var schedule = mutableMapOf(
            "L131" to mutableMapOf("Pargolovo" to "12:50", "as" to "13:56", "bi" to "16:10", "vi" to "17:50"),
            "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
            "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
            "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
            "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23"))
   // mutableMapOf<String, MutableMap<String, String>>()


    private fun timeMaker(map: MutableMap<String, String> ): MutableMap<String, String> {
        val newMap = mutableMapOf<Int, String>()
        for ((key, value) in map) {
            val per = value.split(":")
            val timeInMin = per[0].toInt() * 60 + per[1].toInt()
            newMap[timeInMin] = key
        }
        val sortedMap = newMap.toSortedMap()
        val endSchedule = mutableMapOf<String, String>()
        for ((key, value) in sortedMap) {
            val timeInHour = key / 60
            val timeInMin = key % 60
            val timeInStr = "$timeInHour:$timeInMin"
            endSchedule[value] = timeInStr
        }
        return endSchedule
    }
    fun removeStation(nameStation: String, nameTrain: String): Map<String, MutableMap<String, String>> {
        val makeSchedule = schedule[nameTrain]
        makeSchedule!!.remove(nameStation)
        schedule[nameTrain] = timeMaker(makeSchedule)
        return schedule
    }

    fun addStation(nameTrain: String, nameStation: String, time: String): Map<String, MutableMap<String, String>> {
        val makeSchedule = schedule[nameTrain]
        makeSchedule!![nameStation] = time
        schedule[nameTrain] = timeMaker(makeSchedule)
        return schedule
    }
    fun addTrain(nameTrain: String, station: String, time: String): MutableMap<String, MutableMap<String, String>> {
        val map = mutableMapOf<String, String>()
        map[station] = time
        schedule[nameTrain] = map
        return schedule
    }
    fun removeTrain(nameTrain: String): MutableMap<String, MutableMap<String, String>> {
        schedule.remove(nameTrain)
        return schedule
    }
}


//Хранит расписание поездов для определённой станции отправления.
//// Для каждого поезда хранится конечная станция и список промежуточных.
////
////Методы: добавить новый поезд (название поезда,
//// время отправления, конечная станция), удалить поезд,
//// добавить / удалить промежуточную станцию существующему поезду,
//// поиск ближайшего по времени поезда (по станции, куда едем, и текущему времени).