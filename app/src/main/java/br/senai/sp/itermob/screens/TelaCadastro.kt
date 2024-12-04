package br.senai.sp.itermob.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import br.senai.sp.itermob.R
import br.senai.sp.itermob.model.Usuario
import br.senai.sp.itermob.service.RetrofitFactory
import br.senai.sp.itermob.ui.theme.ItermobTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(navController: NavController) {
    val cpf = remember { mutableStateOf("") }
    val nome = remember { mutableStateOf("") }
    val sobrenome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val telefone = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.tela_cadastro),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section with Back Icon and Logo
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.navigate("home") },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // App Logo (Bus Icon)
                Image(
                    painter = painterResource(id = R.drawable.onibus), // Certifique-se de ter essa imagem
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(200.dp)

                )
            }

            // Input Fields
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CustomTextField(
                    value = cpf.value,
                    onValueChange = { cpf.value = it },
                    label = "CPF",
                    keyboardType = KeyboardType.Number
                )
                CustomTextField(
                    value = nome.value,
                    onValueChange = { nome.value = it },
                    label = "Nome"
                )
                CustomTextField(
                    value = sobrenome.value,
                    onValueChange = { sobrenome.value = it },
                    label = "Sobrenome"
                )
                CustomTextField(
                    value = telefone.value,
                    onValueChange = { telefone.value = it },
                    label = "Telefone",
                    keyboardType = KeyboardType.Number
                )
                CustomTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = "E-mail"
                )
                CustomTextField(
                    value = senha.value,
                    onValueChange = { senha.value = it },
                    label = "Senha"
                )
            }

            // Submit Button
            Button(
                onClick = {
                    val usuario = Usuario(
                        cpf = cpf.value,
                        nome = nome.value,
                        sobrenome = sobrenome.value,
                        email = email.value,
                        telefone = telefone.value,
                        senha = senha.value
                    )

                    val retrofitFactory = RetrofitFactory()
                    val usuarios = retrofitFactory.postUsuarioService()

                    usuarios.postUsuario(usuario).enqueue(object : Callback<Usuario> {
                        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                            if (response.isSuccessful) {
                                Log.d("response","Resposta ${response.body()}")
                                navController.navigate("cadastroFinalizado")
                            } else {
                                Log.e(
                                    "response",
                                    "Erro ao cadastrar: Código ${response.code()}, Mensagem: ${response.message()}"
                                )
                            }
                        }

                        override fun onFailure(call: Call<Usuario>, t: Throwable) {
                            Log.e("response", "Falha na requisição: ${t.message}")
                        }
                    })
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffFFC222))
            ) {
                Text(
                    text = "Próximo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        colors = TextFieldDefaults.colors(Color.Black),
        label = { Text(label, fontSize = 16.sp, color = Color.Gray) }
    )
}

@Preview
@Composable
fun TelaCadastroPreview() {
    ItermobTheme {
        TelaCadastro(NavHostController(LocalContext.current))
    }
}
