package com.task.NehaGote.view_model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.task.NehaGote.repository.CountryRepository
import com.task.NehaGote.response.CountryResponse

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val countryRepository: CountryRepository
    val countryResponseLiveData: LiveData<CountryResponse?>

    init {
        countryRepository = CountryRepository()
        countryResponseLiveData = countryRepository.countryNames
    }
}