package com.aelwyhn.cosby.di

import com.aelwyhn.cosby.ui.GoogleMapViewModel
import dagger.Component

@Component(
    modules = [GoogleMapModule::class],
    dependencies = [CoreProvider::class]
)
@GoogleMapScope
interface GoogleMapComponent {

    @Component.Factory
    interface Factory {
        fun create(coreProvider: CoreProvider): GoogleMapComponent
    }

    fun getGoogleMapViewModel(): GoogleMapViewModel
}
