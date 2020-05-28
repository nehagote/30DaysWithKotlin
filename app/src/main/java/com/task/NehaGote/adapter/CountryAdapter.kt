package com.task.NehaGote.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.task.NehaGote.R
import com.task.NehaGote.model.Country
import java.util.*

class CountryAdapter(var countryArrayList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.content_countrylist, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val country = countryArrayList[i]
        viewHolder.tv_Name.text = country.name
    }

    override fun getItemCount(): Int {
        return countryArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_Name: TextView

        init {
            tv_Name = itemView.findViewById(R.id.tv_Name)
        }
    }

}