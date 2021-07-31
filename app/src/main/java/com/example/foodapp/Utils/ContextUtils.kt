package com.example.foodapp.Utils

import android.content.Context
import android.view.View
import android.widget.Toast
import es.dmoral.toasty.Toasty

object ContextUtils {

    fun Context?.showWarningToasty(str: String) {
        Toasty.warning(this!!, str, Toast.LENGTH_SHORT, true).show();

    }
}