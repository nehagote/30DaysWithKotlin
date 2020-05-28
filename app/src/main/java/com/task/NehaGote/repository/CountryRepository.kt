package com.task.NehaGote.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.gson.Gson
import com.task.NehaGote.response.CountryResponse
import com.task.NehaGote.retrofit.ApiRequest
import com.task.NehaGote.retrofit.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {
    val countryNames: LiveData<CountryResponse?>
        get() {
            val apiRequest = RetrofitRequest.retrofitInstance?.create(ApiRequest::class.java)
            val data = MutableLiveData<CountryResponse?>()
            if (apiRequest != null) {
                apiRequest.countryNames
                        ?.enqueue(object : Callback<CountryResponse?> {
                            override fun onResponse(call: Call<CountryResponse?>, response: Response<CountryResponse?>) {
                                Log.e("onResponse ", Gson().toJson(response.body()))
                                if (response.body() != null) {
                                    data.value = response.body()
                                }
                            }

                            override fun onFailure(call: Call<CountryResponse?>, t: Throwable) {
                                data.value = null
                            }
                        })
            }
            return data
        }
}