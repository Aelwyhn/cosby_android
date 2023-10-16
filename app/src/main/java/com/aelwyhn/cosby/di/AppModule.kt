package com.aelwyhn.cosby.di

import android.content.Context
import com.aelwyhn.cosby.CosbyApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: CosbyApplication): Context {
        return app.applicationContext
    }
}
