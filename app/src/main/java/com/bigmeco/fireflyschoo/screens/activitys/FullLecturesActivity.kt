package com.bigmeco.fireflyschoo.screens.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.LecturesPojo
import com.bigmeco.fireflyschoo.models.implementation.ImageLoadingModel
import kotlinx.android.synthetic.main.activity_full_lectures.*

class FullLecturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_lectures)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        val intent = this.intent
        val bundle = intent.extras
        val thumbs = bundle.getSerializable("value") as LecturesPojo
        supportActionBar!!.title = thumbs.title
        textBody.text = thumbs.body
        if (thumbs.image != null && thumbs.image != "") {
            ImageLoadingModel().urlToImage(thumbs.image!!) {
                floatingActionButton.setImageBitmap(it)
            }
        }
        if (thumbs.images != null) {
            if (thumbs.images!!.size > 0) {
                ImageLoadingModel().urlToImage(thumbs.images!![0]) {
                    imageView1.setImageBitmap(it)
                }
            }
            if (thumbs.images!!.size >= 2) {
                ImageLoadingModel().urlToImage(thumbs.images!![1]) {
                    imageView2.setImageBitmap(it)
                }
            }
            if (thumbs.images!!.size >= 3) {
                ImageLoadingModel().urlToImage(thumbs.images!![2]) {
                    imageView3.setImageBitmap(it)
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
