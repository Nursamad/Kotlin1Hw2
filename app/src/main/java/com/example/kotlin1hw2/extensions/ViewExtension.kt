package com.example.kotlin1hw2.extensions
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlin.random.Random

fun ImageView.load(url: String) {
    Glide.with(this).load(url).into(this)
}
 fun <T> Collection<T>.customRandom(): T {
    return random(Random)
}
