package com.quantum.vpn

import android.app.Application
import android.content.Context


class AppApplication : Application() {

    companion object {
        private var context: Context? = null

        fun getApplicationContext(): Context? {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}