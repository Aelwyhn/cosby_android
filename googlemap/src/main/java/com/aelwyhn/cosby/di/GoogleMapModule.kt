package com.aelwyhn.cosby.di

import android.content.Context
import com.aelwyhn.cosby.ui.GoogleMapViewModel
import com.aelwyhn.cosby.utils.LocationHolder
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides

@Module
internal class GoogleMapModule {

    @Provides
    fun provideLocationHolder(context: Context): LocationHolder {
        return LocationHolder(LocationServices.getFusedLocationProviderClient(context))
    }

    @Provides
    @GoogleMapScope
    fun provideGoogleMapViewModel(locationHolder: LocationHolder): GoogleMapViewModel {
        return GoogleMapViewModel(locationHolder)
    }
}
