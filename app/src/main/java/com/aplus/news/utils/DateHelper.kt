package com.aplus.news.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateHelper @Inject constructor() {
    @SuppressLint("SimpleDateFormat")
    fun changeFormatTime(time: String): String {
        return try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US)
            val date = simpleDateFormat.parse(time)
            date?.let {
                SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date)
            } ?: time
        } catch (e: Exception) {
            time
        }
    }
}