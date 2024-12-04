package br.senai.sp.itermob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.itermob.R

@Composable
fun TelaHistorico(navController: NavController) {
    val historicoItems = listOf(
        "25 - Jd. Popular | 15/08 - 6:32",
        "25 - Jd. Popular | 14/08 - 19:22",
        "21 - Jd. Capriotti | 14/08 - 12:26",
        "25 - Jd. Popular | 13/08 - 18:18",
        "25 - Jd. Popular | 12/08 - 19:20",
        "25 - Jd. Popular | 12/08 - 19:20",
        "25 - Jd. Popular | 12/08 - 19:20",
        "25 - Jd. Popular | 12/08 - 19:20"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Parte superior com a imagem do ônibus (ajustado para não interferir na lista)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFF4C430)) // Fundo ajustado
        ) {
            Image(
                painter = painterResource(id = R.drawable.onibus),
                contentDescription = "Imagem do Ônibus",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }

        // Lista de históricos com espaçamento e alinhamento
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Faz a lista ocupar o restante da tela
                .padding(horizontal = 16.dp)
        ) {
            items(historicoItems) { item ->
                HistoricoItem(item)
            }
        }

        // Footer fixado na parte inferior
        FooterHistorico(navController)
    }
}

@Composable
fun HistoricoItem(item: String) {
    val parts = item.split(" | ") // Dividir item em ponto e data/hora
    val ponto = parts[0]
    val dataHora = parts[1]

    // Layout do item com melhor formatação
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFF8F8F8), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Texto do ponto
        Text(
            text = ponto,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f), // Deixa o ponto ocupar o espaço restante
            fontWeight = FontWeight.Bold
        )

        // Texto da data/hora
        Text(
            text = dataHora,
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
    }
}

@Composable
fun FooterHistorico(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color(0xFFF4C430)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf(
            R.drawable.icon_refresh to "login",
            R.drawable.icon_home to "home",
            R.drawable.icon_favorite to "fac",
            R.drawable.icon_settings to "configuracoes"
        ).forEach { (icon, route) ->
            Box(
                modifier = Modifier
                    .background(Color(0xFFFFF6E0), shape = RoundedCornerShape(40.dp))
                    .size(45.dp)
                    .clickable { navController.navigate(route) }
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp).align(Alignment.Center)
                )
            }
        }
    }
}
