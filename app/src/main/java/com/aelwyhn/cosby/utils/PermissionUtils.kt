package com.aelwyhn.cosby.utils

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

const val LOCATION_REQUEST_CODE = 1001

fun Activity.doIfLocationPermissionGranted(action: () -> Unit = {}) {
    val isPermissionGranted =
        isPermissionGranted(ACCESS_FINE_LOCATION) && isPermissionGranted(ACCESS_COARSE_LOCATION)
    if (isPermissionGranted) {
        action()
    } else {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),
            LOCATION_REQUEST_CODE
        )
    }
}

fun Activity.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) ==
            PackageManager.PERMISSION_GRANTED
}
