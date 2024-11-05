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
import androidx.compose.material.Card
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.itermob.R

@Composable
fun TelaFac(navController: NavController){

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
            Column(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(top = 20.dp)
                        .background(
                            color = Color(0xffFFF6E0),
                    shape = RoundedCornerShape(40.dp)
                )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(2.dp) // Espaço entre as linhas de cards
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp), // Espaço entre os cards dentro da Box
                            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaço entre os cards
                            verticalAlignment = Alignment.CenterVertically // Alinha os cards verticalmente no centro
                        ) {

                            //card 1
                            Card(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(110.dp)
                                    .width(130.dp),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 20.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.pranchetas),
                                        contentDescription = "Reporte image",
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .size(60.dp)
                                    )
                                    Text(
                                        text = "Reportar Item",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                }
                            }
                            //card2
                            Card(
                                modifier = Modifier
                                    .padding(20.dp)
                                    .height(110.dp)
                                    .width(140.dp),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 20.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.megafone),
                                        contentDescription = "Denuncia image",
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .size(60.dp)
                                    )
                                    Text(
                                        text = "Denúncias",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaço entre os cards
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //card 3
                            Card(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(110.dp)
                                    .width(130.dp),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 20.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.telemarketing),
                                        contentDescription = "Acompanhe aqui image",
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .size(60.dp)
                                    )
                                    Text(
                                        text = "Acompanhar",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                }
                            }
                            //card 4
                            Card(
                                modifier = Modifier
                                    .padding(20.dp)
                                    .height(110.dp)
                                    .width(140.dp),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 20.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.duvidas),
                                        contentDescription = "Duvidas image",
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .size(60.dp)
                                    )
                                    Text(
                                        text = "Dúvidas",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,

                                        )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp), // Espaço entre os cards dentro da Box
                            horizontalArrangement = Arrangement.Center, // Alinha o card no centro
                            verticalAlignment = Alignment.CenterVertically // Alinha o card verticalmente
                        ) {
                            // Card centralizado
                            Card(
                                modifier = Modifier
                                    .height(100.dp) // Altura ajustada
                                    .width(160.dp), // Largura ajustada
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 20.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.informacoes ),
                                        contentDescription = "Informacoes image",
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .size(50.dp) // Tamanho ajustado
                                    )
                                    Text(
                                        text = "Feedback",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }




                }






            }

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
                    .background(Color(0xFFEDE2C4), shape = RoundedCornerShape(40.dp))
                    .size(60.dp)
                    .clickable {
                        navController.navigate("fac")
                    }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.chat_black),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
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
                    painter = painterResource(id = R.drawable.config_black),
                    contentDescription = "",
                    modifier = Modifier
                        .size(35.dp) // Tamanho do ícone
                        .align(Alignment.Center)
                )
            }
        }

     }

    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaFacPrev() {
    TelaFac(navController = NavController(LocalContext.current))
}

