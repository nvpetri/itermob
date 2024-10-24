package br.senai.sp.itermob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.senai.sp.itermob.R
import kotlinx.coroutines.delay

@Composable
fun TelaSplash(navController: NavHostController) {
    // Simular o carregamento com delay de 3 segundos
    LaunchedEffect (Unit) {
        delay(3000) // Simula o carregamento
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true } // Remove a Splash da pilha de navegação
        }
    }

    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.splashimg),
            contentDescription = "Itermob Splash Screen",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}