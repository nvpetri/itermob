package br.senai.sp.itermob.service

import br.senai.sp.itermob.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Usuarios {
    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuarios>>

    @GET("usuarios/{id}")
    fun getUsuarioById(@Path("id") id: Int): Call<Usuarios>

    @POST("usuarios")
    fun postUsuario(usuario: Usuario): Call<Usuarios>
}