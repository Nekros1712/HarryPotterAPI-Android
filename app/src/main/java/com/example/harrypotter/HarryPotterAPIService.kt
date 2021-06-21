package com.example.harrypotter

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HarryPotterInterface {
    @GET("characters")
    fun getCharacters() : Call<List<HarryPotterData>>
}

object HarryPotterAPIService {
    val hp_instance: HarryPotterInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://hp-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        hp_instance = retrofit.create(HarryPotterInterface::class.java)
    }
}