package com.aelwyhn.cosby.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapView() {
    val mapProperties = MapProperties(
        // todo
//        isMyLocationEnabled = false
    )
    val cameraPositionState = rememberCameraPositionState()
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = mapProperties,
        cameraPositionState = cameraPositionState,
    ) {

    }
}