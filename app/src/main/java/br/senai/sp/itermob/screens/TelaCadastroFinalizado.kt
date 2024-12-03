package br.senai.sp.itermob.screens

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.itermob.R
import br.senai.sp.itermob.model.LoginUsuario
import br.senai.sp.itermob.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TelaCadastroFinalizado(navigationController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7C3))  // Cor de fundo suave (amarelo claro)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                // Card com bordas arredondadas e sombra
                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape), // Ícone circular
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color.White),
                ) {
                    // Ícone de sucesso centralizado
                    Image(
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = "Ícone de Sucesso",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Texto de sucesso
            Text(
                text = "Usuário cadastrado com sucesso!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp),
                lineHeight = 28.sp // Ajuste na altura da linha para melhor legibilidade
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    navigationController.navigate("home")
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
                    text = "Continuar",
                    color = Color.White,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TelaCadastroFinalizadoPreview() {
    TelaCadastroFinalizado(navigationController = NavController(LocalContext.current))
}
