package com.example.foodapp.data.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfferItem(
    var id: Int,
    val title: String,
    val rating: Double,
    val numOfRatings: Int,
    val category: String,
    val location: String,
    val url: String = "",
    @DrawableRes val photoDrawable: Int = 0
) : Parcelable
