package com.example.desafioandroid.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid.data.model.News
import com.example.desafioandroid.R
import com.example.desafioandroid.data.model.Item
import com.example.desafioandroid.data.repository.NewsService
import com.example.desafioandroid.data.repository.RetrofitInstance
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newsService: NewsService
    private val listNewsItems: MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        newsService = RetrofitInstance
            .getRetrofitInstance()
            .create(NewsService::class.java)

        val listNews: RecyclerView = findViewById(R.id.listNews)
        listNews.layoutManager = LinearLayoutManager(this)

        getAllNews(listNews, listNewsItems)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getAllNews(listNews: RecyclerView, listNewsItems: MutableList<Item>) {

        val responseLiveData: LiveData<Response<News>> = liveData {
            val response = newsService.getAllNews()
            emit(response)
        }

        responseLiveData.observe(this, {
            val newsItems = it.body()

            listNews.adapter = NewsAdapter(
                listNewsItems
            ) { selectedNewsItem: List<Item>?, position: Int -> clickNewsItem(selectedNewsItem, position) }

            if (newsItems != null) {
                listNewsItems.addAll(newsItems.items)
                listNews.adapter!!.notifyDataSetChanged()
            }

        })
    }

    private fun clickNewsItem(listNewsItems: List<Item>?, position: Int) {

        val intent = Intent(this@MainActivity, WebActivity::class.java)
        val bundle = Bundle()

        bundle.putString("link", listNewsItems?.get(position)?.link)

        intent.putExtras(bundle)
        startActivity(intent)

    }

}