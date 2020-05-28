package com.task.NehaGote.retrofit

import com.task.NehaGote.response.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {
    @get:GET("countries")
    val countryNames: Call<CountryResponse?>?
}