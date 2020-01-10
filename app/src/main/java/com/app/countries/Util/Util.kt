package com.app.countries.Util

import android.widget.ImageView
import com.app.countries.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(uri: String?){
   val option = RequestOptions()
       .error(R.mipmap.ic_launcher)

    Glide.with(this.context)
        .setDefaultRequestOptions(option)
        .load(uri)
        .into(this)

}
