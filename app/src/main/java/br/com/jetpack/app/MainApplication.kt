package br.com.jetpack.app

import android.app.Application
import br.com.jetpack.extentions.startKoinApp

/**
 *Created by humbertokalex
 */

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinApp()
    }
}