package br.senai.sp.itermob.screens

import android.Manifest
import android.content.pm.PackageManager
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.senai.sp.itermob.R
import br.senai.sp.itermob.ui.theme.ItermobTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng


@Composable
fun TelaHome(navController: NavController) {
    val saoPaulo = LatLng(-23.5505, -46.6333) // Latitude e longitude de São Paulo
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(saoPaulo, 14f) // Zoom ajustado
    }
    var pesquisa by remember { mutableStateOf("") }

    // Layout Principal
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF4C430))) { // Cor ajustada

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

        // Container do Mapa com Ícone de Alerta
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(2.dp, Color.White, RoundedCornerShape(20.dp))
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = com.google.maps.android.compose.rememberMarkerState(
                        position = saoPaulo
                    ),
                    title = "São Paulo",
                    snippet = "A maior cidade do Brasil!"
                )
            }

            // Ícone de Alerta sobre o Mapa
            Image(
                painter = painterResource(id = R.drawable.alert_icon),
                contentDescription = "Alerta",
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.TopEnd) // Ícone movido para o topo
                    .padding(16.dp)
                    .background(Color.Yellow, shape = RoundedCornerShape(28.dp))
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(28.dp)) // Adicionada borda preta
                    .padding(10.dp)
            )
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

            FavoriteRouteCard("25 - Jd. Popular", "5 min")
            Spacer(modifier = Modifier.height(8.dp))
            FavoriteRouteCard("831 - Trevo Alphaville", "5 min")
        }

        // Rodapé com Ícones
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFFF4C430)), // Cor ajustada
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //historico
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {
                        navController.navigate("login")
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_refresh),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Center)
                )
            }
            //home
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(60.dp)
                    .clickable {
                        navController.navigate("home")

                    }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                )
            }

            //chat
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {

                    }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Center)
                )
            }
            //config
            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE2C4), shape = RoundedCornerShape(40.dp))
                    .size(45.dp) // Tamanho do background
                    .clickable { navController.navigate("configuracoes") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_settings),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp) // Tamanho do ícone
                        .align(Alignment.Center)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .offset(y = 90.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            //historico
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {
                        navController.navigate("login")
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_refresh),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Center)
                )
            }
            //home
            Box(
                modifier = Modifier
                    .background(Color(0xFFEDE2C4), shape = RoundedCornerShape(40.dp))
                    .size(60.dp)
                    .clickable {
                        navController.navigate("home")

                    }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                )
            }

            //chat
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {
                        navController.navigate("fac")
                    }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Center)
                )
            }
            //config
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp) // Tamanho do background
                    .clickable { navController.navigate("configuracoes") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_settings),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp) // Tamanho do ícone
                        .align(Alignment.Center)
                )
            }
        }
    }

    // Solicitação de Permissões de Localização
    LocationPermissionRequest()
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
                modifier = Modifier.size(20.dp) // Ícone de som adicionado
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = time)
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
        hasCoarseLocationPermission =
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
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
