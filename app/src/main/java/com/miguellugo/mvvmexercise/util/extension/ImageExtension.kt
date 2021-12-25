package com.miguellugo.mvvmexercise.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String?){
    if (!url.isNullOrEmpty())
        Glide.with(this.context).load(url).into(this)
}