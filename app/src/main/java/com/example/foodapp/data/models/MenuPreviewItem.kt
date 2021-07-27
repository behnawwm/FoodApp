package com.example.foodapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuPreviewItem(
    var id: Int,
    val title: String,
    val rating: Double,
    val numOfRatings: Int,
    val category: String,
    val location: String,
    val url: String = ""
) : Parcelable
