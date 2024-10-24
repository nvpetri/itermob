package br.senai.sp.itermob.screens

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.senai.sp.itermob.ui.theme.ItermobTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

@Composable
fun TelaHome(navController: NavController) {
    val saoPaulo = LatLng(-23.5505, -46.6333) // Latitude e longitude de São Paulo

    // Definindo o estado da posição da câmera corretamente
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(saoPaulo, 10f)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .background(Color.White)
            ) {}

            // Google Map Composable
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                cameraPositionState = cameraPositionState
            ) {
                // Marcador no mapa
                Marker(
                    state = com.google.maps.android.compose.rememberMarkerState(
                        position = saoPaulo
                    ),
                    title = "São Paulo",
                    snippet = "A maior cidade do Brasil!"
                )
            }

            // Chamando o LocationPermissionRequest
            LocationPermissionRequest()
        }
    }
}

@Composable
fun LocationPermissionRequest() {
    var hasFineLocationPermission by remember { mutableStateOf(false) }
    var hasCoarseLocationPermission by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasFineLocationPermission = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        hasCoarseLocationPermission = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
    }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasFineLocationPermission || !hasCoarseLocationPermission) {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaHomePrev() {
    val context = LocalContext.current
    val navController = remember { NavHostController(context) }

    TelaHome(navController = navController)

}
