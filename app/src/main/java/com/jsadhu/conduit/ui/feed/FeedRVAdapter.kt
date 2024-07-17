package com.jsadhu.conduit.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jsadhu.api.models.entities.Article
import com.jsadhu.conduit.R

class FeedRVAdapter : RecyclerView.Adapter<FeedRVAdapter.FeedViewHolder>() {

    private var articles: List<Article> = listOf()

    fun submitList(articleList : List<Article>) {
        this.articles = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRVAdapter.FeedViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedRVAdapter.FeedViewHolder, position: Int) {
        holder.articleTitle.text = articles[position].title.substring(0, 30)
        holder.articleContent.text = articles[position].body.substring(0, 300)
        holder.articleAuthor.text = "Author: ${articles[position].author.username}"
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class FeedViewHolder(itemView: View) : ViewHolder(itemView) {
        val articleTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val articleContent = itemView.findViewById<TextView>(R.id.tv_content)
        val articleAuthor = itemView.findViewById<TextView>(R.id.tv_author)
    }
}