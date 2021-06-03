package com.example.musicsearchapp

import android.app.Application
import com.example.musicsearchapp.di.retroFitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MusicSearchApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MusicSearchApp)
            modules(retroFitModule)
        }
    }
}