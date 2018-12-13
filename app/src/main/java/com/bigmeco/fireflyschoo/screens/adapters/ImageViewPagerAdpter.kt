package com.bigmeco.fireflyschoo.screens.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.bigmeco.fireflyschoo.screens.fragments.ImageFragment
import android.os.Bundle




class ImageViewPagerAdpter(fm: FragmentManager,val images: ArrayList<String>) : FragmentStatePagerAdapter(fm) {



    override fun getItem(i: Int): Fragment {
        val fragment = ImageFragment()
        val args = Bundle()
        args.putString("IMAGE", images[i])
        fragment.arguments = args
        return fragment
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Item " + (position + 1)
    }

}