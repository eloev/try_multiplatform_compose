package com.yelloyew.common

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class KmmApp : Application() {

    companion object {
        var appContext by Delegates.notNull<Context>()
    }

    override fun onCreate() {
        appContext = applicationContext
        super.onCreate()
    }
}