package com.bigmeco.fireflyschoo.models.implementation

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.Log
import com.bigmeco.fireflyschoo.models.contracts.IImageLoadingModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.IOException
import kotlin.coroutines.resume


class ImageLoadingModel : IImageLoadingModel {
    var target: Target? = null
    override suspend fun urlToImage(url: String): Bitmap? {

        return suspendCancellableCoroutine { continuation ->
            target = object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    try {
                        continuation.resume(bitmap)
                    } catch (e: IllegalStateException) {
                    }

                    Log.d("eeeeeeeeeee", "onBitmapLoaded")
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    val handler = Handler()
                    handler.postDelayed({ Picasso.get().load(url).into(target!!) }, 2000)

                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }
            }
            try {
                Picasso.get().load(url).into(target!!)
            } catch (e: IOException) {

            }
        }

    }
}