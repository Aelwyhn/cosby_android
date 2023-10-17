package com.aelwyhn.cosby.di

import com.aelwyhn.cosby.CosbyApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class],
)
interface AppComponent : CoreProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: CosbyApplication): AppComponent
    }

    fun inject(app: CosbyApplication)
}
