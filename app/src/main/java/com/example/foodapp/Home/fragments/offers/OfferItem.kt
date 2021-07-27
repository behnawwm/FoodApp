package com.example.foodapp.Home.fragments.offers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfferItem(
    var id: Int,
    val title: String,
    val rating: Double,
    val numOfRatings: Int,
    val category: String,
    val location: String,
    val url: String = ""
) : Parcelable
