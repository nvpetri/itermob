package br.senai.sp.itermob.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.itermob.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastroAutenticacao(navigationController: NavHostController) {

    var senha by remember {
        mutableStateOf("")
    }
    var confirmarSenha by remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.tela_cadastro),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            IconButton(
                onClick = {
                    navigationController.navigate("cadastroEndereco")
                },
                modifier = Modifier.width(50.dp)

            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .offset(y = (-50).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.onibus),
                    contentDescription = "Onibus Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .width(150.dp)
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(340.dp)
                    .height(800.dp)
                    .offset(y = (-80).dp)
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    value = senha,
                    onValueChange = {
                        senha = it
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        Color.Cyan
                    ),
                    label = {
                        Text(
                            "Crie sua senha",
                            fontSize = 18.sp,
                            color = Color.Gray
                        )
                    }
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    value = confirmarSenha,
                    onValueChange = {
                        confirmarSenha = it
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        Color.Transparent
                    ),
                    label = {
                        Text(
                            "Confirme sua senha",
                            fontSize = 18.sp,
                            color = Color.Gray
                        )
                    }
                )

                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .width(400.dp)
                        .height(400.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { navigationController.navigate("cadastroFinalizado") },
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffFFC222)),
                    ) {
                        Text(
                            "Cadastrar",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaCadastroAutenticacaoPrev() {
    TelaCadastroAutenticacao(navigationController = NavHostController(LocalContext.current))
}