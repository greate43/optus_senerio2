package com.greate43.sk.optussenerio2.utilities

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "error", "placeholder")
fun loadImage(view: ImageView, url: String, error: Drawable, placeholder: Drawable) {
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .into(view)

}