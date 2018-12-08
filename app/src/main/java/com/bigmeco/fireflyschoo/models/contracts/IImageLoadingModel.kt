package com.bigmeco.fireflyschoo.models.contracts

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface IImageLoadingModel {
    suspend fun urlToImage(url: String): Bitmap?
}