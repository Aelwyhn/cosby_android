package com.aelwyhn.cosby

import android.app.Application
import com.aelwyhn.cosby.di.DaggerAppComponent

class CosbyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }
}
