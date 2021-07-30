package com.example.foodapp.data.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuPreviewItem(
    var id: Int,
    val title: String,
    val rating: Double,
    val category: String,
    val location: String,
    val price: Double,
    val url: String = "",
    @DrawableRes val photoDrawable: Int = 0
) : Parcelable
