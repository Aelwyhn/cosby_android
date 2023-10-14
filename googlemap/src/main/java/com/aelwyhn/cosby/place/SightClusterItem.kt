package com.aelwyhn.cosby.place

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class SightClusterItem(
    val name: String,
    val description: String,
    val latLng: LatLng,
) : ClusterItem {

    override fun getPosition(): LatLng =
        latLng

    override fun getTitle(): String =
        name

    override fun getSnippet(): String =
        description

    override fun getZIndex(): Float = 0f
}
