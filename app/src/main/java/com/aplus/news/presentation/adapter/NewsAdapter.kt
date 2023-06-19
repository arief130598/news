package com.aplus.news.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aplus.news.R
import com.aplus.news.databinding.RvNewsBinding
import com.aplus.news.domain.model.News
import com.aplus.news.utils.DateHelper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class NewsAdapter(
    private val fragment: Fragment,
    private var items: List<News>,
    private val onClickNews: (News) -> Unit,
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val dateHelper = DateHelper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    inner class ViewHolder(private val binding: RvNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: News) = with(binding) {
            binding.date.text = dateHelper.changeFormatTime(item.createdAt)
            binding.contributor.text = item.contributorName
            Glide.with(fragment)
                .load(item.contentThumbnail)
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .centerCrop()
                .into(binding.poster)
            binding.title.text = item.title
            binding.description.text = limitOverview(item.content)

            mainCard.setOnClickListener { onClickNews(item) }
            executePendingBindings()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<News>) {
        this.items = data
        notifyDataSetChanged()
    }

    fun limitOverview(data: String): String {
        return if (data.length > 200) {
            var overview = data.substring(0, 200)
            if (overview[overview.length - 1] != '.') {
                overview = "$overview..."
            }
            overview
        } else {
            data
        }
    }
}