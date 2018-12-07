package com.bigmeco.fireflyschoo.screens.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.screens.adapters.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsPojos =ArrayList<NewsPojo>()
        newsPojos.add(NewsPojo())
        newsPojos.add(NewsPojo())
        newsPojos.add(NewsPojo())
        newsList.layoutManager = LinearLayoutManager(activity)
        newsList.adapter = NewsAdapter(newsPojos) {
        }
    }
}
