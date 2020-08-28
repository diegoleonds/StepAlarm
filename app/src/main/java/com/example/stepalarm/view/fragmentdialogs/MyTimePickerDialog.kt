package com.example.stepalarm.view.fragmentdialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.stepalarm.view.activities.TimePickerDialogListener
import com.example.stepalarm.view.model.Schedule
import java.util.*

class MyTimePickerDialog(
    val listener: TimePickerDialogListener
) : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))
    }

    override fun onTimeSet(view: TimePicker, hour: Int, minute: Int) {
        listener.onTimeChanged(
            Schedule(
                hour.toString(),
                minute.toString()
            )
        )
    }
}