package br.senai.sp.itermob.screens

import android.widget.Toast
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.*
import br.senai.sp.itermob.R
import br.senai.sp.itermob.model.Usuario
import br.senai.sp.itermob.service.RetrofitFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(navigationController: NavHostController) {

    var cpf by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.tela_cadastro),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            IconButton(
                onClick = { navigationController.navigate("home") },
                modifier = Modifier.width(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier.width(50.dp).height(50.dp)
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
                    modifier = Modifier.fillMaxSize().width(150.dp)
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
                CustomTextField(
                    value = cpf,
                    onValueChange = { cpf = it },
                    label = "CPF",
                    keyboardType = KeyboardType.Number
                )
                CustomTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = "Nome"
                )
                CustomTextField(
                    value = sobrenome,
                    onValueChange = { sobrenome = it },
                    label = "Sobrenome"
                )
                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "E-mail"
                )
                CustomTextField(
                    value = telefone,
                    onValueChange = { telefone = it },
                    label = "Telefone",
                    keyboardType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier.width(400.dp).height(400.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            if (cpf.isNotEmpty() && email.isNotEmpty()) {
                                val usuario = Usuario(cpf, nome, sobrenome, email, telefone)
                                    val response = RetrofitFactory().postUsuarioService(usuario)
                                    if (response.isSuccessful) {
                                        navigationController.navigate())
                                    } else {
                                        Text(
                                            "Erro ao cadastrar usuário",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Red
                                        )
                                    }
                            } else {
                                Text(
                                    "Preencha todos os campos",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Red
                                )
                            }
                        },
                        modifier = Modifier.width(150.dp).height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffFFC222))
                    ) {
                        Text(
                            "Próximo",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    if (showSuccessSnackbar) {
                        LaunchedEffect(key1 = snackbarHostState) {
                            snackbarHostState.showSnackbar("Usuário cadastrado com sucesso!")
                            showSuccessSnackbar = false
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
        label = { Text(label, fontSize = 18.sp, color = Color.Gray) }
    )
}

@Preview(showSystemUi = true)
@Composable
fun TelaCadastroPreview() {
    val navController = remember { NavHostController(LocalContext.current) }
    TelaCadastro(navigationController = navController)
}
