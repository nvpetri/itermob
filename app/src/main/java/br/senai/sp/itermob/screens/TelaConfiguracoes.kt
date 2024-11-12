package br.senai.sp.itermob.screens


import android.graphics.Rect
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import br.senai.sp.itermob.R

@Composable
fun TelaConfiguracoes(navController: NavHostController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
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
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.configuracoes),
                    contentDescription = "Config image",
                    modifier = Modifier
                        .size(45.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Configurações",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(60.dp, 60.dp)
                        .clickable {
                            navController.navigate("dadosPessoais")
                        },
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Dados Pessoais",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp)
                        .clickable {
                            navController.navigate("cartoesSalvos")
                        },
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )

                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Cartões",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp)
                        .clickable {

                        },
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Endereços salvos",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp)
                        .clickable {

                        },
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )

                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Segurança",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )

                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Aparência",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )

                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ajuda",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .size(80.dp, 60.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffFFF6E0)
                    )

                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Políticas e termos",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .offset(y = 128.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
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
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaConfiguracoesPrev() {
    TelaConfiguracoes(navController = NavHostController(LocalContext.current))
}


