package com.bigmeco.fireflyschoo.screens.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.models.implementation.ImageLoadingModel
import com.bigmeco.fireflyschoo.screens.adapters.ImageViewPagerAdpter
import kotlinx.android.synthetic.main.activity_courses.*
import android.R.attr.delay
import android.support.v4.os.HandlerCompat.postDelayed
import com.bigmeco.fireflyschoo.R.id.viewPager




class FullCoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        val intent = this.intent
        val bundle = intent.extras
        val thumbs = bundle.getSerializable("value") as CoursesPojo
        supportActionBar!!.title = thumbs.title
        textBody.text = thumbs.body
        if (thumbs.image != null && thumbs.image != "") {
            ImageLoadingModel().urlToImage(thumbs.image!!) {
                floatingActionButton.setImageBitmap(it)
            }
        }
        if (thumbs.images != null) {

        val mTextPagerAdapter = ImageViewPagerAdpter(
                supportFragmentManager, thumbs.images!!)

        app_bar_image.adapter = mTextPagerAdapter

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
