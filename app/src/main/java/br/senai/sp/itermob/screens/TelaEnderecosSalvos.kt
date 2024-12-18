package br.senai.sp.itermob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
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
import androidx.navigation.NavController
import br.senai.sp.itermob.R

@Composable
fun TelaEnderecosSalvos(navController: NavController) {

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
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Dados Pessoais",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Start)
                    .offset(y = 35.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.seta),
                    contentDescription = "seta Image",
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .size(50.dp)
                        .clickable {
                            navController.navigate("configuracoes")
                        }
                )
            }
            Spacer(modifier = Modifier.height(250.dp))
            Row(
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("addEnderecos")
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xffFFC222)
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.mais),
                            contentDescription = "mais image",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Text(
                        " Adicionar Endereço",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        //rodapé menu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .offset(y = 390.dp),
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
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable {
                        navController.navigate("home")

                    }
            ){
                Icon(painter = painterResource(id = R.drawable.home_white),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
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
                    .background(Color(0xFFEDE2C4), shape = RoundedCornerShape(40.dp))
                    .size(60.dp) // Tamanho do background
                    .clickable { navController.navigate("configuracoes") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.config_black),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp) // Tamanho do ícone
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaEnderecoSalvosPrev() {
    TelaEnderecosSalvos(navController = NavController(LocalContext.current))
}