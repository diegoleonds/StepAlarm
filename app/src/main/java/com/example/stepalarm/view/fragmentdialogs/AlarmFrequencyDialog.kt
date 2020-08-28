package com.example.stepalarm.view.fragmentdialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.stepalarm.R
import com.example.stepalarm.view.activities.FrequencyDialogListener

class AlarmFrequencyDialog(
    val listener: FrequencyDialogListener
) : DialogFragment() {
    lateinit var list: Array<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            list = arrayOf(
                getString(R.string.frequency_once),
                getString(R.string.frequency_daily),
                getString(R.string.frequency_working_week),
                getString(R.string.frequency_custom)
            )
            val builder = AlertDialog.Builder(it)
            builder
                .setItems(
                    list
                ) { dialog, which ->
                    listener.onChanged(list[which])
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}