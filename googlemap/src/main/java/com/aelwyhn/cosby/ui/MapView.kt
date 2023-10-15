package com.aelwyhn.cosby.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.aelwyhn.cosby.extensions.animateToCenter
import com.aelwyhn.cosby.utils.LocationHolder
import com.aelwyhn.cosby.utils.configure
import com.aelwyhn.cosby.utils.createClusterManager
import com.google.android.gms.location.LocationServices
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapEffect
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@Composable
fun GoogleMapView(
    onNavigateNext: () -> Unit
) {
    val mapProperties = MapProperties(
        isMyLocationEnabled = true
    )
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState()
    val viewModel =
        MapViewModel(LocationHolder(LocationServices.getFusedLocationProviderClient(context)))
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = mapProperties,
        cameraPositionState = cameraPositionState,
    ) {
        val scope = rememberCoroutineScope()

        MapEffect(key1 = viewModel.state.value.lastKnownLocation) { googleMap ->
            val items = viewModel.state.value.clusterItems
            val myPosition = viewModel.state.value.lastKnownLocation
            googleMap.setOnMapLoadedCallback {
                if (myPosition != null) {
                    val clusterManager = googleMap.createClusterManager(context, items)
                    googleMap.configure(clusterManager)
                    scope.launch {
                        cameraPositionState.animateToCenter(myPosition)
                    }
                }
            }
        }
    }
}
