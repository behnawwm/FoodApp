package com.example.foodapp.data

import com.example.foodapp.R
import com.example.foodapp.data.models.MenuPreviewItem
import com.example.foodapp.data.models.OfferItem

object TestDataSet {

    fun provideFoodTestDataSet(): MutableList<MenuPreviewItem> {
        return mutableListOf(
            MenuPreviewItem(
                0,
                "Pizza",
                4.8,
                "Foods",
                "Paris Palace",
                14.99,
                photoDrawable = R.drawable.photo_pizza
            ),
            MenuPreviewItem(
                1,
                "Hamburger",
                3.5,
                "Foods",
                "Eye of London",
                9.99,
                photoDrawable = R.drawable.photo_hamburger
            ),
            MenuPreviewItem(
                2,
                "Hotdog",
                2.1,
                "Foods",
                "Uchimara Osaki",
                11.99,
                photoDrawable = R.drawable.photo_hotdog
            ),
            MenuPreviewItem(
                3,
                "Steak",
                4.9,
                "Foods",
                "Metropolis",
                24.99,
                photoDrawable = R.drawable.photo_steak
            ),
            MenuPreviewItem(
                4,
                "French Fries",
                3.9,
                "Foods",
                "FastBood",
                4.99,
                photoDrawable = R.drawable.photo_fries
            ),
        )
    }

    fun provideBeveragesTestDataSet(): MutableList<MenuPreviewItem> {
        return mutableListOf(
            MenuPreviewItem(
                0,
                "Soda",
                4.8,
                "Beverages",
                "Paris Palace",
                14.99,
                photoDrawable = R.drawable.photo_soda
            ),
            MenuPreviewItem(
                1,
                "Lemonade",
                3.5,
                "Beverages",
                "Eye of London",
                9.99,
                photoDrawable = R.drawable.photo_lemonade
            ),
            MenuPreviewItem(
                2,
                "Cappuccino",
                2.1,
                "Beverages",
                "Uchimara Osaki",
                11.99,
                photoDrawable = R.drawable.photo_cappuccino
            ),
            MenuPreviewItem(
                3,
                "Orange Juice",
                4.9,
                "Beverages",
                "Metropolis",
                24.99,
                photoDrawable = R.drawable.photo_orange_juice
            )
        )
    }

    fun provideAppetizersTestDataSet(): MutableList<MenuPreviewItem> {
        return mutableListOf(
            MenuPreviewItem(
                0,
                "Nachos",
                4.8,
                "Appetizers",
                "Paris Palace",
                14.99,
                photoDrawable = R.drawable.photo_nachos
            ),
            MenuPreviewItem(
                1,
                "Potato skins",
                3.5,
                "Appetizers",
                "Eye of London",
                9.99,
                photoDrawable = R.drawable.photo_potato_skins
            ),
            MenuPreviewItem(
                2,
                "Mozzarella Sticks",
                2.1,
                "Appetizers",
                "Uchimara Osaki",
                11.99,
                photoDrawable = R.drawable.photo_mozzarella_sticks
            ),
            MenuPreviewItem(
                2,
                "Onion Rings",
                3.1,
                "Appetizers",
                "Uchimara Osaki",
                11.99,
                photoDrawable = R.drawable.photo_onion_rings
            )
        )
    }

    fun provideDessertsTestDataSet(): MutableList<MenuPreviewItem> {
        return mutableListOf(
            MenuPreviewItem(
                0,
                "Waffles",
                4.8,
                "Desserts",
                "Paris Palace",
                14.99,
                photoDrawable = R.drawable.photo_waffles
            ),
            MenuPreviewItem(
                1,
                "Cheesecake",
                3.5,
                "Desserts",
                "Eye of London",
                9.99,
                photoDrawable = R.drawable.photo_cheesecake
            ),
            MenuPreviewItem(
                2,
                "Donuts",
                2.1,
                "Desserts",
                "Uchimara Osaki",
                11.99,
                photoDrawable = R.drawable.photo_donuts
            ),
            MenuPreviewItem(
                3,
                "Pancakes",
                4.9,
                "Desserts",
                "Metropolis",
                24.99,
                photoDrawable = R.drawable.photo_pancakes
            )
        )
    }
    fun provideOffersTestDataSet(): MutableList<OfferItem> {
        return mutableListOf(
            OfferItem(
                0, "Pizza", 4.8, 123, "Desserts", "Paris",
                photoDrawable = R.drawable.photo_pizza
            ),
            OfferItem(
                1,
                "Cheeseburger",
                3.5,
                231,
                "Fast Food",
                "London Eye",
                photoDrawable = R.drawable.photo_hamburger
            ),
            OfferItem(
                2,
                "Small Hotdog",
                2.1,
                3,
                "Fast Food",
                "Paris Nights",
                photoDrawable = R.drawable.photo_hotdog
            ),
            OfferItem(
                3,
                "Cheesecake",
                4.9,
                41,
                "Desserts",
                "Teddy Bear",
                photoDrawable = R.drawable.photo_cheesecake
            ),
            OfferItem(
                4,
                "Soda",
                3.9,
                2309,
                "Beverages",
                "Triple A",
                photoDrawable = R.drawable.photo_soda
            ),
        )
    }

}