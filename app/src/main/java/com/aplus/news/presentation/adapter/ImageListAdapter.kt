package com.aplus.news.presentation.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aplus.news.R
import com.aplus.news.databinding.RvImagelistBinding
import com.bumptech.glide.Glide

class ImageListAdapter(
    private val context: Context,
    private var items: List<String>,
    private val onClickNews: (String) -> Unit,
) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    private var currentPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvImagelistBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(holder, items[position])

    inner class ViewHolder(private val binding: RvImagelistBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(holder: ViewHolder, item: String) = with(binding) {
            Glide.with(context)
                .load(item)
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .centerCrop()
                .into(image)

            if(holder.adapterPosition == currentPosition) image.foreground = null
            else image.foreground = ColorDrawable(
                ContextCompat.getColor(context, R.color.gray_50)
            )

            image.setOnClickListener {
                image.foreground = null
                val positionBefore = currentPosition
                currentPosition = holder.adapterPosition
                notifyItemChanged(positionBefore)
                onClickNews(item)
            }
            executePendingBindings()
        }
    }
}