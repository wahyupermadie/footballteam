package com.example.wahyupermadi.footballteam.api

import com.example.wahyupermadi.footballteam.model.Android
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {

    @GET("api/android")
    fun getData(): Observable<List<Android>>

    companion object {
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://learn2crack-json.herokuapp.com/")
                    .build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}