package com.example.stepalarm.viewmodel.di

import com.example.stepalarm.viewmodel.AddAlarmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AddAlarmViewModel() }
}