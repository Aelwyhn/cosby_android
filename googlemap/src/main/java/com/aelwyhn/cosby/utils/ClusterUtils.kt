package com.aelwyhn.cosby.utils

import android.annotation.SuppressLint
import android.content.Context
import com.aelwyhn.cosby.place.SightClusterItem
import com.aelwyhn.cosby.place.SightClusterManager
import com.aelwyhn.cosby.place.SightsRenderer
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.clustering.ClusterManager

internal fun GoogleMap.createClusterManager(
    context: Context,
    places: List<SightClusterItem>
): ClusterManager<SightClusterItem> {
    // Create the ClusterManager class and set the custom renderer
    val clusterManager = SightClusterManager(context, this)
    clusterManager.renderer =
        SightsRenderer(
            context,
            this,
            clusterManager
        )

    // Set custom info window adapter
//    clusterManager.markerCollection.setInfoWindowAdapter(object: : GoogleMap.InfoWindowAdapter)

    // Add the places to the ClusterManager
    clusterManager.addItems(places)
    clusterManager.cluster()

    // Show polygon
    clusterManager.setOnClusterItemClickListener { item ->
//        addCircle(googleMap, item)
        return@setOnClusterItemClickListener false
    }

    return clusterManager
}

@SuppressLint("PotentialBehaviorOverride")
internal fun GoogleMap.configure(clusterManager: ClusterManager<SightClusterItem>) {
    setOnCameraMoveStartedListener {
//            clusterManager.clusterMarkerCollection.markers.forEach { it.alpha = 0.3f }
    }

    setOnCameraIdleListener {
        // Call clusterManager.onCameraIdle() when the camera stops moving so that re-clustering
        // can be performed when the camera stops moving
        clusterManager.onCameraIdle()
    }

    setOnMarkerClickListener(clusterManager)
}
