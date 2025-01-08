package com.example.meet14

import android.app.Application
import com.example.meet14.DI.AppContainer
import com.example.meet14.DI.MahasiswaContainer

class MahasiswaApplications : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}