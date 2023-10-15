package com.aelwyhn.cosby.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aelwyhn.cosby.ui.GoogleMapView

const val GOOGLE_MAP_SCREEN = "GOOGLE_MAP_SCREEN"

fun NavGraphBuilder.googleMapScreen(
    onNavigateNext: () -> Unit
) {
    composable(
        route = GOOGLE_MAP_SCREEN
    ) {
        GoogleMapView(onNavigateNext)
    }
}
