package com.bigmeco.fireflyschoo.screens.activitys

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.presenters.presenterLogic.NavigationPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.NavigationView
import com.bigmeco.fireflyschoo.screens.fragments.CoursesFragment
import com.bigmeco.fireflyschoo.screens.fragments.InfoFragment
import com.bigmeco.fireflyschoo.screens.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_navigation.*
import eightbitlab.com.blurview.RenderScriptBlur
import com.bigmeco.fireflyschoo.R.id.blurView
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import com.bigmeco.fireflyschoo.screens.fragments.LecturesFragment


class NavigationActivity : MvpAppCompatActivity(), NavigationView {


    @InjectPresenter
    lateinit var navigationPresenter: NavigationPresenter

    @ProvidePresenter
    fun provideNavigationPresenter(): NavigationPresenter {
        return NavigationPresenter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        Log.d("NavigationActivity",intent.getStringExtra("UID"))
        transitionFragment(NewsFragment())

        val radius = 5f
        val decorView = window.decorView
        val rootView = decorView.findViewById(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.action_news -> transitionFragment(NewsFragment())
                R.id.action_courses -> transitionFragment(CoursesFragment())
                R.id.action_lectures -> transitionFragment(LecturesFragment())
                R.id.action_user -> transitionFragment(InfoFragment())
            }
            true
        }
    }

    private fun transitionFragment(newFragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragments, newFragment)
        ft.commit()
    }
}
