package com.bigmeco.fireflyschoo.screens.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.screens.adapters.ViewPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment() {
    private var mAdapter: ViewPagerAdapter? = null
    private var mFragmentChosenByUser = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = ViewPagerAdapter(fragmentManager)

        viewPager.adapter = mAdapter
        viewPager.currentItem = 0
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                Log.i("POSITION_IN_FRAGMENT", "result " + position)
                mFragmentChosenByUser = position
            }

            override fun onPageScrollStateChanged(p0: Int) {
            }
        })
        tabs.setupWithViewPager(viewPager)

    }

}
