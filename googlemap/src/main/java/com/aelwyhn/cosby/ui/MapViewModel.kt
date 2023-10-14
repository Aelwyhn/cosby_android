package com.aelwyhn.cosby.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.aelwyhn.cosby.ui.data.MapState
import com.aelwyhn.cosby.utils.LocationHolder

internal class MapViewModel(
    private val locationHolder: LocationHolder,
) : ViewModel() {

    init {
        refreshLocation()
    }

    val state: MutableState<MapState> = mutableStateOf(
        MapState(
            lastKnownLocation = null,
            clusterItems = listOf()
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
