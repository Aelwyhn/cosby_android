package com.aelwyhn.cosby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aelwyhn.cosby.ui.theme.CosbyTheme
import com.aelwyhn.cosby.ui.theme.navigation.AppNavGraph
import com.aelwyhn.cosby.utils.doIfLocationPermissionGranted

private const val LOCATION_REQUEST_CODE = 1001

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doIfLocationPermissionGranted { setContent() }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_REQUEST_CODE) {
            doIfLocationPermissionGranted { setContent() }
        }
    }

    private fun setContent() {
        setContent {
            val navController = rememberNavController()
            CosbyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavGraph(navHostController = navController)
                }
            }
        }
    }
}
