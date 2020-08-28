package com.example.stepalarm.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.stepalarm.R
import com.example.stepalarm.view.fragmentdialogs.AlarmFrequencyDialog
import com.example.stepalarm.view.fragmentdialogs.MyTimePickerDialog
import com.example.stepalarm.view.model.Schedule
import com.example.stepalarm.view.utils.TextFormatter
import com.example.stepalarm.viewmodel.AddAlarmViewModel
import kotlinx.android.synthetic.main.activity_add_alarm.*
import kotlinx.android.synthetic.main.option_item.view.*
import kotlinx.android.synthetic.main.option_item_with_switch.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddAlarmActivity : AppCompatActivity(), TimePickerDialogListener, FrequencyDialogListener {

    val viewModel: AddAlarmViewModel by viewModel()
    val textFormatter: TextFormatter = TextFormatter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alarm)

        setClicks()
        observeScheduleOfViewModel()
        setOptionItemsName()
    }

    private fun setOptionItemsName(){
        optionRepeat.optionNameTextView.text = getString(R.string.repeat_option)
        optionRepeat.optionResult.text = getString(R.string.frequency_once)
        optionAlarmName.optionNameTextView.text = getString(R.string.name_option)
        optionAlarmName.optionImageView.visibility = View.GONE

        optionAlarmType.optionWithSwitchName.text = getString(R.string.vibrate_option)
        optionRemoveAfterRing.optionWithSwitchName.text = getString(R.string.delete_after_ring_option)
    }

    private fun setClicks(){
        setCancelBtnClick()
        setTimeTextViewClick()
        setRepeatClick()
    }

    private fun setRepeatClick(){
        optionRepeat.setOnClickListener{
            AlarmFrequencyDialog(this).show(supportFragmentManager, "frequencyDialog")
        }
    }

    private fun setCancelBtnClick(){
        cancelImgBtn.setOnClickListener {
            finish()
        }
    }

    private fun setTimeTextViewClick(){
        alarmTimeTextView.setOnClickListener{
            MyTimePickerDialog(this).show(supportFragmentManager, "timePicker")
        }
    }

    private fun observeScheduleOfViewModel(){
        viewModel.timeObserver.observe(this, Observer {
            alarmTimeTextView.text = textFormatter.formatSchedule(it)
        })
    }

    override fun onTimeChanged(schedule: Schedule) {
        viewModel.timeObserver.value = schedule
    }

    override fun onChanged(frequency: String) {
        optionRepeat.optionResult.text = frequency
    }
}

interface TimePickerDialogListener{
    fun onTimeChanged(schedule: Schedule)
}

interface FrequencyDialogListener{
    fun onChanged(frequency: String)
}
