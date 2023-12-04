package com.paupiette.laba4.ui.tasks

import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class GetViewModel : ViewModel() {

    suspend fun executeGetRequest(): String {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.ru/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)
        val response = service.getGoogle()

        return response.body().toString()
    }
}

interface ApiService {
    @GET("/")
    suspend fun getGoogle(): Response<String>
}
