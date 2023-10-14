package com.aelwyhn.cosby.extensions

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

fun GoogleMap.createOverlay(
    image: BitmapDescriptor,
    pos: LatLng,
    width: Float = 100f
) {
    val overlay = GroundOverlayOptions()
        .image(image)
        .position(pos, width)
    addGroundOverlay(overlay)
}

fun GoogleMap.showMarker(
    title: String,
    pos: LatLng,
    description: String? = null,
    isShowMarker: Boolean = false,
) {
    val options = MarkerOptions()
        .position(pos)
        .title(title)
    description?.let { options.snippet(it) }
    val marker = addMarker(options)
    if (isShowMarker) {
        marker?.showInfoWindow()
    }
    marker?.tag = pos
}
