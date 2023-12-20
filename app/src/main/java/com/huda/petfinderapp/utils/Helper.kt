package com.huda.petfinderapp.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.ContextThemeWrapper
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.huda.petfinderapp.R
import com.tapadoo.alerter.Alerter

object Helper {
    fun loadImage(context: Context, path: String, photo: ImageView) {
        Glide.with(context).load(path)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .fallback(R.drawable.img_placeholder)
            .into(photo)
    }
    fun showErrorDialog(context: Context, message: String) {
        context.getActivity()?.let {
            Alerter.create(it, R.layout.dialog_error)
                .setBackgroundColorRes(android.R.color.transparent)
                .also { alerter ->
                    val messageTv = alerter.getLayoutContainer()?.findViewById<TextView>(R.id.message)
                    messageTv?.text = message
                }.show()
        }
    }
    private fun Context.getActivity(): Activity? {
        return when (this) {
            is Activity -> this
            is ContextThemeWrapper -> this.baseContext.getActivity()
            else -> null
        }
    }
}


