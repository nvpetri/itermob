package br.senai.sp.itermob.service

import br.senai.sp.itermob.model.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {
    private val BaseURL= "http://10.107.134.28:8080/v1/itermob/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUsuariosService(): Usuarios {
        return retrofitFactory.create(Usuarios::class.java)
    }


    fun postUsuarioService(): Usuarios {
        return retrofitFactory.create(Usuarios::class.java)
    }
}
