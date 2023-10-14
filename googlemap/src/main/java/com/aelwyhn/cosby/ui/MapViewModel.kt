package com.aelwyhn.cosby.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.aelwyhn.cosby.place.SightClusterItem
import com.aelwyhn.cosby.ui.data.MapState
import com.aelwyhn.cosby.utils.LocationHolder
import com.google.android.gms.maps.model.LatLng

internal class MapViewModel(
    private val locationHolder: LocationHolder,
) : ViewModel() {

    init {
        refreshLocation()
    }

    val state: MutableState<MapState> = mutableStateOf(
        MapState(
            lastKnownLocation = null,
            clusterItems = listOf(
                SightClusterItem(
                    name = "Zone 1",
                    description = "This is Zone 1.",
                    latLng = LatLng(49.1, -122.506)
                ),
                SightClusterItem(
                    name = "Zone 2",
                    description = "This is Zone 2.",
                    latLng = LatLng(49.105, -122.524)
                )
            )
        )
    )

    fun refreshLocation() {
        return locationHolder.refreshSelfLocation { newLocation ->
            state.value = state.value.copy(
                lastKnownLocation = newLocation
            )
        }
    }
}
