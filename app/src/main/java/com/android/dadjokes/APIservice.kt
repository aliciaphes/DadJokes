package com.android.dadjokes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIservice{
    @Headers("Accept: application/json")
    @GET(" ")
    fun getRandomJoke(/*param: String?*/): Call<Joke>

    companion object {
        const val API_URL = "https://icanhazdadjoke.com/"
    }
}