package com.aelwyhn.cosby.ui.data

import android.location.Location
import com.aelwyhn.cosby.place.SightClusterItem

data class MapState(
    val lastKnownLocation: Location?,
    val clusterItems: List<SightClusterItem>,
)
