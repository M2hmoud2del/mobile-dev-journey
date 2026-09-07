package com.excercise.newsapp

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.excercise.newsapp.databinding.ArticleListItemBinding

class NewsAdapter(val a: Activity, val articles: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val b = ArticleListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(b)
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        Log.d("trace","url: ${articles[position].urlToImage}")
        holder.binding.articleTV.text = articles[position].title
        Glide
            .with(holder.binding.articleIV.context)
            .load(articles[position].urlToImage)
            .error(R.drawable.broken_image)
            .transition(DrawableTransitionOptions.withCrossFade(1000))
            .into(holder.binding.articleIV)

        val url = articles[position].url

        holder.binding.articleCV.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, url.toUri() )
            a.startActivity(i)
        }

        holder.binding.shareFab.setOnClickListener {
            ShareCompat
                .IntentBuilder(a)
                .setType("text/plain")
                .setChooserTitle("Share Article With:")
                .setText(url)
                .startChooser()
        }
    }

    override fun getItemCount() = articles.size

    class NewsViewHolder(val binding: ArticleListItemBinding): RecyclerView.ViewHolder(binding.root)
}