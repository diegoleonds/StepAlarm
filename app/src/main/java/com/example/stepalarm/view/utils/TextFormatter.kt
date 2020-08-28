package com.example.stepalarm.view.utils

import com.example.stepalarm.view.model.Schedule

class TextFormatter {

    fun formatSchedule(schedule: Schedule): String{
        if (schedule.minute.length < 2)
            schedule.minute = "0${schedule.minute}"

        return schedule.toString()
    }
}