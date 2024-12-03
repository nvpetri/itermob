package br.senai.sp.itermob.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.itermob.R
import br.senai.sp.itermob.model.LoginUsuario
import br.senai.sp.itermob.model.RespostaLogin
import br.senai.sp.itermob.model.Usuario
import br.senai.sp.itermob.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


@Composable
fun TelaLogin(navigationController: NavHostController) {

    val retrofitFactory = RetrofitFactory()
    val usuariosService = retrofitFactory.postUsuarioService()

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var erroLoginState = remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    var isLoading = remember { mutableStateOf(false) }


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
                    navigationController.navigate("home")
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
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.onibus),
                    contentDescription = "Onibus Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .width(150.dp)
                )

            }
            Spacer(modifier = Modifier.height(120.dp))
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(340.dp)
                    .height(800.dp)
                    .offset(y = (-80).dp)
            ) {

//                Espaco para inserir o email

                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text("Email")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color.Black)
                    }
                )

//                Espaco para inserir a senha
                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    isError = erroLoginState.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text("Senha")
                    },
                    shape = RoundedCornerShape(26.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color.Black)
                    }
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigationController.navigate("") },
                    text = "Esqueceu sua senha?",
                    textAlign = TextAlign.End,
                    color = Color(0xffFFC222)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Column (
                    modifier = Modifier
                        .width(400.dp)
                        .height(400.dp),
                    horizontalAlignment  = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                            isLoading.value = true
                            val loginData = LoginUsuario(email = emailState.value, senha = senhaState.value)

                            usuariosService.enviarLogin(loginData).enqueue(object : Callback<Usuario> {
                                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                                    if (response.isSuccessful) {
                                        val usuario = response.body()
                                        Log.i("Login", "Bem-vindo, ${usuario?.nome}")
                                        navigationController.navigate("home")
                                    } else {
                                        Log.e("Login", "Erro ao fazer login: ${response.code()}")
                                    }
                                }

                                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                                    Log.e("Login", "Erro de conexão: ${t.message}")
                                }
                            })
                        },
                        modifier = Modifier
                            .height(46.dp)
                            .width(300.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xffFFC222), Color(0xffFFC222))
                                ),
                                shape = RoundedCornerShape(30.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues()
                    ) {
                        Text(
                            text = if (isLoading.value) "Carregando..." else "Entrar",
                            color = Color.White,
                            style = MaterialTheme.typography.button
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    Row{
                        Text(
                            text = "Ainda não tem uma conta?"

                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navigationController.navigate("cadastro") },
                            text = " Clique aqui para criar!",
                            color = Color(0xffFFC222)

                        )
                    }

                }


            }


        }



    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaLoginPrev() {
    TelaLogin(navigationController = NavHostController(LocalContext.current))
}