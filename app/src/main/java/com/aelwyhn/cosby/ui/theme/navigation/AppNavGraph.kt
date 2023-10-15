package com.aelwyhn.cosby.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.aelwyhn.cosby.ui.navigation.GOOGLE_MAP_SCREEN
import com.aelwyhn.cosby.ui.navigation.googleMapScreen

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = GOOGLE_MAP_SCREEN,
        modifier = modifier
    ) {
        googleMapScreen(onNavigateNext = {})
    }
}
