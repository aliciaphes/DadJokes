package com.android.dadjokes

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class APIclient(private val baseURL: String) {

    companion object {
        private var retrofit: Retrofit? = null
    }

    init {
        getClient()
    }


    private fun getClient() {
        if (retrofit == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build()
        }
    }

    fun createService(): APIservice? {
            return retrofit?.create(APIservice::class.java)
    }
}