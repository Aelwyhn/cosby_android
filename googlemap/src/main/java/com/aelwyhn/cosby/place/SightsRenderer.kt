package com.aelwyhn.cosby.place

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer

class SightsRenderer(
    context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<SightClusterItem>
) : DefaultClusterRenderer<SightClusterItem>(context, map, clusterManager) {

    override fun onBeforeClusterItemRendered(item: SightClusterItem, markerOptions: MarkerOptions) {
        markerOptions
            .title(item.name)
            .position(item.latLng)
    }

    override fun onClusterItemRendered(clusterItem: SightClusterItem, marker: Marker) {
        marker.tag = clusterItem
    }
}
