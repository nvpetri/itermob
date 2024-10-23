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
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.senai.sp.itermob.ui.theme.ItermobTheme
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

@Composable
fun TelaHome(navController: NavController) {
    val saoPaulo = LatLng(-23.5505, -46.6333) // Latitude e longitude de São Paulo
    val cameraPositionState = rememberCameraPositionState {
        position = CameraUpdateFactory.newLatLngZoom(saoPaulo, 10f).cameraPosition
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
            Column {
                GoogleMap(

                ) {
                    Marker(
                        position = saoPaulo,
                        title = "São Paulo",
                        snippet = "A maior cidade do Brasil!"
                    )
                }
            }

            // Chamando o LocationPermissionRequest
            LocationPermissionRequest()
        }
    }
}


@Composable
fun LocationPermissionRequest() {
    // Estados para armazenar se as permissões foram concedidas
    var hasFineLocationPermission by remember { mutableStateOf(false) }
    var hasCoarseLocationPermission by remember { mutableStateOf(false) }

    // Lançador de permissões
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasFineLocationPermission = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        hasCoarseLocationPermission = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
    }

    val context = LocalContext.current

    // Verificação das permissões
    LaunchedEffect(Unit) {
        hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        // Se não estiverem concedidas, lança o permissionLauncher
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
private fun TelaHomePrev() {
    ItermobTheme {
        // Armazena o contexto em uma variável separada
        val context = LocalContext.current

        // Cria o NavController usando o contexto fora do remember
        val navController = remember { NavHostController(context) }

        TelaHome(navController = navController)
    }
}

