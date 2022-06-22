package com.example.retrofitapi2022

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("lista_prod")
    fun getAllProd(): Call<List<Producto>>
}