package com.aelwyhn.cosby.extensions

import android.location.Location
import com.aelwyhn.cosby.place.SightClusterItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.CameraPositionState

private const val ZOOM = 15f

suspend fun CameraPositionState.animateToArea(items: List<SightClusterItem>) {
    if (items.isNotEmpty()) {
        val bounds = LatLngBounds.builder()
        items.forEach {
            bounds.include(it.latLng)
        }
        animate(
            update = CameraUpdateFactory.newLatLngBounds(bounds.build(), 0)
        )
    }
}

suspend fun CameraPositionState.animateToCenter(location: Location) {
    val area = LatLng(location.latitude, location.longitude)
    animate(
        update = CameraUpdateFactory.newLatLngZoom(area, ZOOM)
    )
}
