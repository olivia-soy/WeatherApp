package com.olivia.weatherapp.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * WeatherApp
 * BindingAdapter
 * @author leesoyoung
 * @since 2022/05/06
 */

//glide 이용하여 image url 로드
@BindingAdapter(value = ["imagePath"])
fun setImagePath(view: ImageView, imagePath: String?) {
    Glide.with(view.context)
        .load(imagePath)
        .override(500, 500)
        .thumbnail(0.1f)    //thumbnail 0.1f
        .into(view)
}
 