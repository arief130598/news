package com.aplus.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Apps : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}