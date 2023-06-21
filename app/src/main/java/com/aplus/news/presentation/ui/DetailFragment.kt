package com.aplus.news.presentation.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.aplus.news.R
import com.aplus.news.base.BaseFragment
import com.aplus.news.databinding.FragmentDetailBinding
import com.aplus.news.extension.remove
import com.aplus.news.extension.setLinearAdapter
import com.aplus.news.presentation.adapter.ImageListAdapter
import com.aplus.news.utils.DateHelper
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private lateinit var adapter: ImageListAdapter
    @Inject lateinit var dateHelper: DateHelper

    override fun onSetupUI() = with(binding) {
        val item = DetailFragmentArgs.fromBundle(requireArguments()).news

        date.text = dateHelper.changeFormatTime(item.createdAt)
        contributor.text = item.contributorName
        if(item.slideshow.isEmpty()){
            rvImage.remove()
            Glide.with(requireContext())
                .load(item.contentThumbnail)
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .centerCrop()
                .into(poster)
        }else {
            setImage(item.slideshow.first())
            adapter = ImageListAdapter(
                context = requireContext(),
                items = item.slideshow,
                onClickNews = { setImage(it) }
            )
            rvImage.setLinearAdapter(adapter, LinearLayoutManager.HORIZONTAL)
        }
        title.text = item.title
        description.text = item.content
    }

    override fun onObserve() {}

    private fun setImage(image: String) = with(binding) {
        Glide.with(requireContext())
            .load(image)
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .centerCrop()
            .into(poster)
    }
}