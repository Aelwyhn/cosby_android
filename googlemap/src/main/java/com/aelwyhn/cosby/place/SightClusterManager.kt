package com.aelwyhn.cosby.place

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.collections.MarkerManager

internal class SightClusterManager(
    context: Context,
    googleMap: GoogleMap
) : ClusterManager<SightClusterItem>(context, googleMap, MarkerManager(googleMap))
