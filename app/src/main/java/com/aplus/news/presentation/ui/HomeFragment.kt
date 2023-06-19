package com.aplus.news.presentation.ui

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.aplus.news.extension.collectLatestLifecycleFlow
import com.aplus.news.extension.remove
import com.aplus.news.extension.setLinearAdapter
import com.aplus.news.extension.show
import com.aplus.news.R
import com.aplus.news.base.BaseFragment
import com.aplus.news.databinding.FragmentHomeBinding
import com.aplus.news.presentation.adapter.NewsAdapter
import com.aplus.news.presentation.navigation.gotoChosenNews
import com.aplus.news.presentation.viewmodel.HomeViewModel
import com.aplus.news.utils.ResponseResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: NewsAdapter

    override fun onSetupUI() = with(binding) {
        adapter = NewsAdapter(
            context = requireContext(),
            items = listOf(),
            onClickNews = { gotoChosenNews(it) }
        )
        rvData.setLinearAdapter(adapter)
    }

    override fun onObserve() {
        observeNews()
    }

    private fun observeNews() = with(binding) {
        collectLatestLifecycleFlow(viewModel.news) {
            when(it) {
                is ResponseResult.Success -> {
                    mainShimmer.apply {
                        stopShimmer()
                        remove()
                    }
                    adapter.setData(it.data)
                    rvData.show()
                }
                is ResponseResult.Error -> {
                    binding.mainShimmer.apply {
                        stopShimmer()
                        remove()
                    }
                    Toast.makeText(requireContext(), it.throwable.message, Toast.LENGTH_LONG).show()
                }
                ResponseResult.Loading -> {
                    mainShimmer.apply {
                        startShimmer()
                        show()
                    }
                    rvData.remove()
                }
            }
        }
    }
}