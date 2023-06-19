package com.aplus.news.domain.model

import android.os.Parcelable
import com.aplus.news.utils.KeyConstants.EMPTY_STRING
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var id: Int = 0,
    var createdAt: String = EMPTY_STRING,
    var contributorName: String = EMPTY_STRING,
    var title: String = EMPTY_STRING,
    var content: String = EMPTY_STRING,
    var contentThumbnail: String = EMPTY_STRING,
    var slideshow: List<String> = listOf()
) : Parcelable
