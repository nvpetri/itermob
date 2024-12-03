package br.senai.sp.itermob.model

data class Usuario(

    val cpf: String,
    val nome: String,
    val sobrenome: String,
    val email: String,
    val telefone: String,
    val senha: String,
)

data class LoginUsuario(
    val email: String = "",
    val senha: String = ""
)

data class RespostaLogin(
    val status_code: Int?,
    val message: String?
)