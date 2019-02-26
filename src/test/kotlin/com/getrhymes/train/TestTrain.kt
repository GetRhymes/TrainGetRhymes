package com.getrhymes.train

import junit.framework.Assert.assertEquals
import org.junit.Test

class TestTrain {
    @Test
    fun addTrainTest () {
        val newTrain = TrainSchedule(nameTrain = "N111", time = "14:35", station = "Arc", needStation = "Spb",
                timeNow = "13:30")
        assertEquals(mutableMapOf(
                "L131" to ("12:50" to "Pargolovo"),
                "M132" to ("12:40" to "Viborg"),
                "N133" to ("12:37" to "Finland"),
                "J137" to ("10:49" to "Spb"),
                "N111" to ("14:35" to "Arc")), newTrain.addTrain())
    }

    @Test
    fun removeTrainTest() {
        val oldTrain = TrainSchedule(nameTrain = "L131", time = "12:50", station = "Pargolovo", needStation = "Spb",
                timeNow = "13:30" )
        assertEquals(mutableMapOf(
                "M132" to ("12:40" to "Viborg"),
                "N133" to ("12:37" to "Finland"),
                "J137" to ("10:49" to "Spb")), oldTrain.removeTrain())
    }

    @Test
    fun addStationTest() {
        val newStation = TrainSchedule(nameTrain = "N137", time = "14:35", station = "Arc", needStation = "Spb",
                timeNow = "13:30")
        assertEquals(mutableMapOf(
                "N137" to mutableListOf("12:37" to "Finland", "14:35" to "Arc", "14:39" to "London" ),
                "L131" to mutableListOf("12:30" to "Pargolovo",  "12:40" to "Viborg"),
                "J139" to mutableListOf("7:45" to "Pushkin", "9:49" to "Spb")), newStation.addStation())
    }

    @Test
    fun removeStationTest() {
        val oldStation = TrainSchedule(nameTrain = "L131", time = "12:30", station = "Pargolovo",
                needStation = "Spb", timeNow = "13:30")
        assertEquals(mutableMapOf(
                "N137" to mutableListOf("12:37" to "Finland", "14:39" to "London"),
                "L131" to mutableListOf("12:40" to "Viborg"),
                "J139" to mutableListOf("9:49" to "Spb", "7:45" to "Pushkin")), oldStation.removeStation())
    }

    @Test
    fun searchTrainTest() {
        val needStation = TrainSchedule(nameTrain = "L131", time = "12:30", station = "Pargolovo",
                needStation = "Spb", timeNow = "12:55")
        assertEquals(("12:57" to "G143"), needStation.searchTrain())
    }
}