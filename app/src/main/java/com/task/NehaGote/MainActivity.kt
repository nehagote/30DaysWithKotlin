package com.task.NehaGote

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.task.NehaGote.adapter.CountryAdapter
import com.task.NehaGote.model.Country
import com.task.NehaGote.response.CountryResponse
import com.task.NehaGote.view_model.CountryViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var progressbar: ProgressBar? = null
    private var layoutManager: LinearLayoutManager? = null
    private var countryNamesAdapter: CountryAdapter? = null
    private val countryArrayList = ArrayList<Country>()
    var viewModel_Countries: CountryViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
        countryNames
    }

    private fun initialization() {
        progressbar = findViewById(R.id.progress_getList)
        layoutManager = LinearLayoutManager(this@MainActivity)
        rv_CountryNames?.setLayoutManager(layoutManager)
        rv_CountryNames?.setHasFixedSize(true)
        countryNamesAdapter = CountryAdapter(countryArrayList)
        rv_CountryNames?.setAdapter(countryNamesAdapter)
    }

    val countryNames: Unit
        get() {
            viewModel_Countries = ViewModelProviders.of(this).get(CountryViewModel::class.java)
            viewModel_Countries!!.countryResponseLiveData.observe(this, Observer { articleResponse: CountryResponse? ->
                if (articleResponse != null) {
                    progressbar!!.visibility = View.GONE
                    val countries = articleResponse.countries
                    countryArrayList.addAll(countries!!)
                    countryNamesAdapter!!.notifyDataSetChanged()
                }
            })
        }
}