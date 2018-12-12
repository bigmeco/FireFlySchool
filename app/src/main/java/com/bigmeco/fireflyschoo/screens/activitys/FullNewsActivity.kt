package com.bigmeco.fireflyschoo.screens.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bigmeco.fireflyschoo.R
import kotlinx.android.synthetic.main.activity_full_news.*

class FullNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title =" test"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
