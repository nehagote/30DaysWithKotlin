package com.task.NehaGote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.task.NehaGote.model.Country

class CountryResponse {
    @SerializedName("result")
    @Expose
    var countries: List<Country>? = null
}