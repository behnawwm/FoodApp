package com.example.foodapp.Utils

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.View
import android.widget.Toast
import com.example.foodapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.dmoral.toasty.Toasty

object ViewUtils {

    fun FloatingActionButton.setFabIcon(
        backgroundTintColorId: Int,
        iconTintColorId: Int,
        iconDrawableId: Int
    ) {
        val myFabSrc = resources.getDrawable(iconDrawableId)
        val willBeWhite = myFabSrc.constantState!!.newDrawable().apply {
            mutate()
                .setColorFilter(
                    resources.getColor(iconTintColorId),
                    PorterDuff.Mode.MULTIPLY
                )
        }

        this.backgroundTintList =
            resources.getColorStateList(backgroundTintColorId)
        this.setImageDrawable(willBeWhite)
    }
}