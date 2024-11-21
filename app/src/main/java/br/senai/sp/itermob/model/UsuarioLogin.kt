package br.senai.sp.itermob.model

import android.media.session.MediaSession.Token

data class UsuarioLogin(
    val id_usuario: Int = 0,
    val nome: String,
    val token: String
)
