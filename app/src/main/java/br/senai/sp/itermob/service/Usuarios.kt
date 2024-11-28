package br.senai.sp.itermob.service

import br.senai.sp.itermob.model.Login
import br.senai.sp.itermob.model.LoginUsuario
import br.senai.sp.itermob.model.RespostaLogin
import br.senai.sp.itermob.model.Usuario
import br.senai.sp.itermob.model.UsuarioLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface Usuarios {
    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @GET("usuarios/{id}")
    fun getUsuarioById(@Path("id") id: Int): Call<Usuario>

    @Headers("Content-Type: application/json")
    @POST("usuario")
    fun postUsuario(@Body usuario: Usuario): Call<Usuario>

    @POST("login")
    fun enviarLogin(@Body login: LoginUsuario): Call<RespostaLogin>
}


