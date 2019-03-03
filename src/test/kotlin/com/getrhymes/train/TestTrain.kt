package com.getrhymes.train

import junit.framework.Assert.assertEquals
import org.junit.Test

class TestTrain {
    @Test
    fun addTrainTest () {
        val train = Train(nameTrain = "ff4", station = "Myr", time =  "11:48")
        assertEquals(mutableMapOf(
                "L131" to mutableMapOf("Pargolovo" to "12:50", "as" to "13:56", "bi" to "16:10", "vi" to "17:50"),
                "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
                "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
                "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
                "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23"),
                "ff4" to mutableMapOf("Myr" to "11:48")),
        train.addTrain(train.nameTrain, train.station, train.time))
    }

    @Test
    fun removeTrainTest() {
        val train3 = Train(nameTrain = "Pargolovo", station = "Myr", time =  "11:48")
        assertEquals("L131" to mutableMapOf(
                "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
                "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
                "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
                "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23")),
        train3.removeTrain(train3.nameTrain))
    }

    @Test
    fun addStationTest() {
        val train = Train(nameTrain = "L131", station = "Myr", time =  "11:48")
        assertEquals(mutableMapOf(
                "L131" to mutableMapOf("Pargolovo" to "12:50", "as" to "13:56", "bi" to "16:10", "vi" to "17:50",
                        "Myr" to "11:48"),
                "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
                "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
                "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
                "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23")),
        train.addStation(train.nameTrain, train.station, train.time))
    }

    @Test
    fun removeStationTest() {
        val train = Train(nameTrain = "L131", station = "Pargolovo", time =  "12:50")
        assertEquals(mutableMapOf(
                "L131" to mutableMapOf("as" to "13:56", "bi" to "16:10", "vi" to "17:50",
                        "Myr" to "11:48"),
                "M132" to mutableMapOf("Viborg" to "12:40", "hu" to "13:00", "ed" to "13:52", "ko" to "15:23"),
                "N133" to mutableMapOf("Finland" to "12:37", "Spb" to "10:49", "Kir" to "11:45", "Mar" to "15:34"),
                "J137" to mutableMapOf("Spb" to "10:50", "Kir" to "11:42", "lo" to "16:40"),
                "A111" to mutableMapOf("Kir" to "11:43", "Mar" to "15:35", "LTD" to "16:23")),
               train.removeStation(train.station, train.nameTrain))
    }

    @Test
    fun searchTrainTest() {
        val needStation = "Mar"
        val timeNow = "11:30"
        val train2 = TrainSchedule(station = "Kir")
        assertEquals(("A111" to "11:43"), train2.searchTrain(timeNow ,needStation, train2.station))
    }
}