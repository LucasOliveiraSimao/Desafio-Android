package com.example.desafioandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.R
import com.example.desafioandroid.data.model.Item

class NewsAdapter(
    private val listNewsItems: List<Item>?,
    private val clickListener: (List<Item>?, Int) -> Unit
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return NewsViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNewsItems, position, clickListener)

    }

    override fun getItemCount(): Int {
        return listNewsItems!!.size
    }
}