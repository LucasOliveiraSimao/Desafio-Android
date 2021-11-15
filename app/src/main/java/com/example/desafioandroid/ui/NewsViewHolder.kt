package com.example.desafioandroid.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafioandroid.R
import com.example.desafioandroid.data.model.Item

class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(listNewsItems: List<Item>?, position: Int, clickListener: (List<Item>?, Int) -> Unit) {

        view.findViewById<TextView>(R.id.feed_item_title).text = listNewsItems?.get(position)?.title
        view.findViewById<TextView>(R.id.feed_item_description).text =
            listNewsItems?.get(position)?.description

        Glide.with(view).load(listNewsItems?.get(position)?.thumbnail)
            .into(view.findViewById(R.id.feed_item_image))

        view.setOnClickListener {
            clickListener(listNewsItems, position)
        }
    }
}