package com.bigmeco.fireflyschoo.screens.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.bigmeco.fireflyschoo.screens.fragments.CommunicationFragment
import com.bigmeco.fireflyschoo.screens.fragments.MapFragment
import java.util.ArrayList

class ViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    private val tabTitles = arrayOf("связь", "карта")

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment? {

        return when (position) {
            0 -> CommunicationFragment()
            1 -> MapFragment()
            else -> null
        }
    }
}

