package com.aelwyhn.cosby.di

import com.aelwyhn.cosby.CosbyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class],
    dependencies = [CosbyApplication::class]
)
interface AppComponent : CoreProvider {

    @Component.Factory
    interface Factory {
        fun create(app: CosbyApplication): AppComponent
    }

    fun inject(app: CosbyApplication)
}
