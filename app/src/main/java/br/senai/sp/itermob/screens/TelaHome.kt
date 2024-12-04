package br.senai.sp.itermob.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.itermob.R
import br.senai.sp.itermob.ui.theme.ItermobTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TelaHome(navController: NavController) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    var currentLocation by remember { mutableStateOf<LatLng?>(null) }
    var pesquisa by remember { mutableStateOf("") }

    // Carrega o número de cliques de SharedPreferences
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    var clickCount by remember { mutableStateOf(sharedPreferences.getInt("click_count", 0)) }

    val cameraPositionState = rememberCameraPositionState()

    // Estado para armazenar as rotas favoritas e seus tempos
    var favoriteRoutes by remember {
        mutableStateOf(
            listOf(
                FavoriteRoute("25 - Jd. Popular", 10), // Tempo em minutos
                FavoriteRoute("831 - Trevo Alphaville", 7)
            )
        )
    }

    // Atualização dos tempos das rotas a cada 10 segundos
    LaunchedEffect(favoriteRoutes) {
        while (true) {
            delay(10000) // Espera 10 segundos
            favoriteRoutes = favoriteRoutes.map {
                // Decrementa o tempo se for maior que 0
                if (it.time > 0) {
                    it.copy(time = it.time - 1)
                } else {
                    it // Tempo já chegou a 0
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        getLastKnownLocation(fusedLocationClient, context) { location ->
            currentLocation = location
            cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 14f)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4C430))
    ) {
        // Barra de Busca e Ícone de Notificação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = pesquisa,
                onValueChange = { pesquisa = it },
                placeholder = { Text("Qual seu destino?") },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(id = R.drawable.notificacao),
                contentDescription = "Notificação",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(8.dp)
            )
        }

        // Mapa com localização atual
        Box(
            modifier = Modifier
                .weight(0.6f)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(2.dp, Color.White, RoundedCornerShape(20.dp))
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                currentLocation?.let {
                    Marker(
                        state = com.google.maps.android.compose.rememberMarkerState(
                            position = it
                        ),
                        title = "Sua localização",
                        snippet = "Você está aqui!"
                    )
                }
            }
        }

        // Seção de Favoritos e Rotas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "⭐ Favoritos",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Exibir rotas favoritas dinamicamente
            favoriteRoutes.forEach { route ->
                FavoriteRouteCard(
                    routeName = route.name,
                    time = "${route.time} min"
                )
            }
        }

        // Rodapé com Ícones
        Footer(navController = navController, clickCount = clickCount, onClick = {
            // Alterna entre as telas
            clickCount++
            // Salva o número de cliques em SharedPreferences
            sharedPreferences.edit().putInt("click_count", clickCount).apply()

            if (clickCount % 2 == 1) {
                navController.navigate("login")
            } else {
                navController.navigate("historico")
            }
        })
    }

    // Solicitação de Permissões de Localização
    LocationPermissionRequest()
}

@Composable
fun Footer(navController: NavController, clickCount: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color(0xFFF4C430)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf(
            R.drawable.icon_refresh to "refresh",
            R.drawable.icon_home to "home",
            R.drawable.icon_favorite to "fac",
            R.drawable.icon_settings to "configuracoes"
        ).forEach { (icon, route) ->
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {
                        // A lógica de navegação está agora aqui
                        if (route == "refresh") {
                            onClick()
                        } else {
                            navController.navigate(route)
                        }
                    }
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp).align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun FavoriteRouteCard(routeName: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = routeName)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.sound_icon),
                contentDescription = "Som",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = time)
        }
    }
    Spacer(modifier = Modifier.width(4.dp))
}

@Composable
fun LocationPermissionRequest() {
    val context = LocalContext.current
    var hasFineLocationPermission by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasFineLocationPermission = granted
    }

    LaunchedEffect(Unit) {
        hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasFineLocationPermission) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}

fun getLastKnownLocation(
    fusedLocationClient: FusedLocationProviderClient,
    context: Context,
    onLocationReceived: (LatLng) -> Unit
) {
    // Verifique se a permissão foi concedida
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    onLocationReceived(LatLng(it.latitude, it.longitude))
                }
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    } else {
        // Permissão não concedida
    }
}

data class FavoriteRoute(val name: String, val time: Int)
