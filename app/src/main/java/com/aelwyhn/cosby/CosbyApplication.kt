package com.aelwyhn.cosby

import android.app.Application
import com.aelwyhn.cosby.di.AppComponent
import com.aelwyhn.cosby.di.CoreApplication
import com.aelwyhn.cosby.di.CoreProvider
import com.aelwyhn.cosby.di.DaggerAppComponent

class CosbyApplication : Application(),
    CoreApplication {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(this)
        appComponent?.inject(this)
    }

    override fun provideCoreProvider(): CoreProvider {
        return appComponent!!
    }
}
