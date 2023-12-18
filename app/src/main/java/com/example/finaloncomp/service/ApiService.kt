package com.example.finaloncomp.service

import com.example.finaloncomp.dataclass.PhotoInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<PhotoInfo>
}

fun createApiService(): ApiService {
    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}
