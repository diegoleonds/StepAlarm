package com.example.stepalarm.config

import android.app.Application
import com.example.stepalarm.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(viewModelModule)
        }
    }
}