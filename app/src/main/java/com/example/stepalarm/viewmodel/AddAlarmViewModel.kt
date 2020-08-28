package com.example.stepalarm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stepalarm.view.model.Schedule

interface AddAlarmViewModelInterface{

}

class AddAlarmViewModel() : ViewModel(), AddAlarmViewModelInterface {

    val timeObserver: MutableLiveData<Schedule> = MutableLiveData<Schedule>()
}