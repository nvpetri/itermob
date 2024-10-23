package br.senai.sp.itermob

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.itermob.screens.TelaCadastro
import br.senai.sp.itermob.screens.TelaCadastroAutenticacao
import br.senai.sp.itermob.screens.TelaCadastroEndereco
import br.senai.sp.itermob.screens.TelaCadastroFinalizado
import br.senai.sp.itermob.screens.TelaConfiguracoes
import br.senai.sp.itermob.screens.TelaHome
import br.senai.sp.itermob.screens.TelaLogin
import br.senai.sp.itermob.ui.theme.ItermobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ItermobTheme {
                val navigationControl = rememberNavController()

                NavHost(
                    navController = navigationControl,
                    startDestination = "home"
                )
                {
                    composable(route = "cadastro") { TelaCadastro(navigationControl) }
                    composable(route = "cadastroEndereco") { TelaCadastroEndereco(navigationControl) }
                    composable(route = "cadastroAutenticacao") { TelaCadastroAutenticacao(navigationControl) }
                    composable(route = "home") { TelaHome(navigationControl) }
                    composable(route = "cadastroFinalizado") { TelaCadastroFinalizado(navigationControl) }
                    composable(route = "login") { TelaLogin(navigationControl) }
                    composable(route = "configuracoes") { TelaConfiguracoes(navigationControl) }
                }
            }
        }
    }
}