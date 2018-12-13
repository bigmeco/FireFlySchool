package com.bigmeco.fireflyschoo.screens.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.models.implementation.ImageLoadingModel
import kotlinx.android.synthetic.main.activity_full_news.*


class FullNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val intent = this.intent
        val bundle = intent.extras
        val thumbs = bundle.getSerializable("value") as NewsPojo
        supportActionBar!!.title = thumbs.title
        textBody.text =thumbs.body
        textTime.text =thumbs.time
        if(thumbs.image!=null && thumbs.image != ""){
            ImageLoadingModel().urlToImage(thumbs.image!!) {
                app_bar_image.setImageBitmap(it)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
