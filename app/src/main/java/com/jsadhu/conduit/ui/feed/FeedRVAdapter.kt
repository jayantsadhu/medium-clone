package com.jsadhu.conduit.ui.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jsadhu.api.models.entities.Article
import com.jsadhu.conduit.R

class FeedRVAdapter(private val context : Context, private val articles : List<Article>) : RecyclerView.Adapter<FeedRVAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRVAdapter.FeedViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedRVAdapter.FeedViewHolder, position: Int) {
        holder.articleTitle.text = articles[position].title
        holder.articleContent.text = articles[position].body
        holder.articleAuthor.text = "Author: ${articles[position].author.username}"
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    open class FeedViewHolder(itemView: View) : ViewHolder(itemView) {
        val articleTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val articleContent = itemView.findViewById<TextView>(R.id.tv_content)
        val articleAuthor = itemView.findViewById<TextView>(R.id.tv_author)
    }
}