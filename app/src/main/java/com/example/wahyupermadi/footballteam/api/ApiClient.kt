package com.example.wahyupermadi.footballteam.api
import com.example.wahyupermadi.footballteam.model.TeamResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search_all_teams.php")
    fun getTeam(@Query("l") l : String): Flowable<TeamResponse>

    companion object {
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                    .build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}