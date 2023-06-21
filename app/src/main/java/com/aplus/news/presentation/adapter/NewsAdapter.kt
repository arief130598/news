package com.aplus.news.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplus.news.R
import com.aplus.news.databinding.RvNewsBinding
import com.aplus.news.domain.model.News
import com.aplus.news.utils.DateHelper
import com.bumptech.glide.Glide

class NewsAdapter(
    private val context: Context,
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
            date.text = dateHelper.changeFormatTime(item.createdAt)
            contributor.text = item.contributorName
            Glide.with(context)
                .load(item.contentThumbnail)
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .centerCrop()
                .into(poster)
            title.text = item.title
            description.text = limitContent(item.content)

            mainCard.setOnClickListener { onClickNews(item) }
            executePendingBindings()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<News>) {
        this.items = data
        notifyDataSetChanged()
    }

    fun limitContent(data: String): String {
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