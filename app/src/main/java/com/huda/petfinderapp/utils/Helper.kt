package com.huda.petfinderapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.huda.petfinderapp.R

object Helper {
    fun loadImage(context: Context, path: String, photo: ImageView) {
        Glide.with(context).load(path)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .fallback(R.drawable.img_placeholder)
            .into(photo)
    }
}