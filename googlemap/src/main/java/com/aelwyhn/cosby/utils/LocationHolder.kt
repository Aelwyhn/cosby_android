package com.aelwyhn.cosby.utils

import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient

class LocationHolder(
    private val fusedLocationProvider: FusedLocationProviderClient
) {

    fun refreshSelfLocation(action: (Location) -> Unit) {
        try {
            fusedLocationProvider.lastLocation.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    action(task.result)
                }
            }

        } catch (_: SecurityException) {
        }
    }
}
