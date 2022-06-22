package com.example.retrofitapi2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var service: APIService
    private lateinit var recyclerpro: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://technoworld.overlife.club/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        recyclerpro = findViewById(R.id.recyclerProd)
        recyclerpro.layoutManager = LinearLayoutManager(this)
        service = retrofit.create<APIService>(APIService::class.java)
        obtenerDataApiRest()
    }

    private fun obtenerDataApiRest() {
        service.getAllProd().enqueue(object : Callback<List<Producto>>{
            override fun onResponse(
                call: Call<List<Producto>>,
                response: Response<List<Producto>>
            ) {
                val prods = response?.body()
                recyclerpro.adapter = ProdAdapter(prods!!)

            }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Log.e("ErrorRetroFit", t.message.toString())
            }

        })
    }
}