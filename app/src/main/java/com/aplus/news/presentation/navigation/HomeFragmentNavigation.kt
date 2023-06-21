package com.aplus.news.presentation.navigation

import androidx.navigation.fragment.findNavController
import com.aplus.news.domain.model.News
import com.aplus.news.presentation.ui.HomeFragment
import com.aplus.news.presentation.ui.HomeFragmentDirections

fun HomeFragment.gotoChosenNews(news: News) {
    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(news))
}