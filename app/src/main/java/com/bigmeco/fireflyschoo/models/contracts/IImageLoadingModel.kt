package com.bigmeco.fireflyschoo.models.contracts

import android.graphics.Bitmap

interface IImageLoadingModel {
    fun urlToImage(url: String, respons: (bitmap: Bitmap) -> Unit)
}