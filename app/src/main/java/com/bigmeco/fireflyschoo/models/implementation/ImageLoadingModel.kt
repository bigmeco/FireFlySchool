package com.bigmeco.fireflyschoo.models.implementation

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.Log
import com.bigmeco.fireflyschoo.models.contracts.IImageLoadingModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.IOException
import java.io.ObjectInput


class ImageLoadingModel : IImageLoadingModel {

    var target: Target? = null
    override fun urlToImage(url: String, respons: (bitmap: Bitmap) -> Unit) {
        if (url!=null&&url!="") {
            target = object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    try {
                        bitmap?.let { respons.invoke(it) }
                        Log.d("eeeeeeeeeee", "onBitmapLoaded")
                    } catch (e: NullPointerException) {
                    }

                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    val handler = Handler()
                    handler.postDelayed({ Picasso.get().load(url).into(target!!) }, 2000)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }

            }
            Picasso.get().load(url).into(target!!)
        }
   }
}