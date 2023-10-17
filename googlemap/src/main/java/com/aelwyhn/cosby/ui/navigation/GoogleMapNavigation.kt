package com.aelwyhn.cosby.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aelwyhn.cosby.di.CoreProvider
import com.aelwyhn.cosby.di.DaggerGoogleMapComponent
import com.aelwyhn.cosby.ui.GoogleMapView

const val GOOGLE_MAP_SCREEN = "GOOGLE_MAP_SCREEN"

fun NavGraphBuilder.googleMapScreen(
    onNavigateNext: () -> Unit,
    coreProvider: CoreProvider,
) {
    composable(
        route = GOOGLE_MAP_SCREEN
    ) {
        val component = DaggerGoogleMapComponent.factory().create(coreProvider)
        val googleMapViewModel = component.getGoogleMapViewModel()
        GoogleMapView(googleMapViewModel, onNavigateNext)
    }
}
