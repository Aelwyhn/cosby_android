package com.aelwyhn.cosby.di

import android.content.Context
import com.aelwyhn.cosby.CosbyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: CosbyApplication): Context {
        return app
    }
}
