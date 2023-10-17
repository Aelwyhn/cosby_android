package com.aelwyhn.cosby.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.aelwyhn.cosby.di.CoreApplication

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    NavHost(
        navController = navHostController,
        startDestination = GOOGLE_MAP_SCREEN,
        modifier = modifier
    ) {
        val coreProvider = (context.applicationContext as CoreApplication).provideCoreProvider()
        googleMapScreen(
            onNavigateNext = {},
            coreProvider = coreProvider
        )
    }
}
