package com.getrhymes.train

class Train (val nameTrain: String, val station: String, val time: String, val listStation: MutableMap<String, String> ) {

    fun removeStation(nameStation: String): MutableMap<String, String> {
        listStation.remove(nameStation)
        return listStation
    }

    fun addStation(nameStation: String, time: String): MutableMap<String, String> {
        listStation[nameStation] = time
        return listStation
    }
}


//Хранит расписание поездов для определённой станции отправления.
//// Для каждого поезда хранится конечная станция и список промежуточных.
////
////Методы: добавить новый поезд (название поезда,
//// время отправления, конечная станция), удалить поезд,
//// добавить / удалить промежуточную станцию существующему поезду,
//// поиск ближайшего по времени поезда (по станции, куда едем, и текущему времени).