package com.aelwyhn.cosby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.aelwyhn.cosby.ui.GoogleMapView
import com.aelwyhn.cosby.ui.theme.CosbyTheme
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
            CosbyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GoogleMapView()
                }
            }
        }
    }
}
