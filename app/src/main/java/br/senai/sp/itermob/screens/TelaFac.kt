package br.senai.sp.itermob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.itermob.R

@Composable
fun TelaFac(navController: NavHostController){

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.fundomenu),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.comunicacao),
                    contentDescription = "chat image",
                    modifier = Modifier
                        .size(45.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Fale Conosco",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .background(Color.Gray),

            )
            }
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaFacPrev() {
    TelaFac(navController = NavHostController(LocalContext.current))
}

