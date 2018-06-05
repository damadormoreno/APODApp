package com.deneb.apps.features.apods

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApodsApi {
    @GET("apod?api_key=DEMO_KEY")
    fun getApod() : Call<ApodEntity>

    @GET("apod?api_key=DEMO_KEY")
    fun getRecentsApods(@Query("start_date") startDate: String,
                        @Query("end_date") endDate: String): Call<List<ApodEntity>>
}