package com.example.stepalarm.view.utils

import com.example.stepalarm.view.model.Schedule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TextFormatterTest {

    val textFormatter: TextFormatter = TextFormatter()

    @Test
    fun formatSchedule() {
        val schedule = Schedule("10", "1")
        assertEquals("10:01", textFormatter.formatSchedule(schedule))
    }
}