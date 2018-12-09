package com.bigmeco.fireflyschoo.screens.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.presenters.presenterLogic.NewsPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.NewsView
import com.bigmeco.fireflyschoo.screens.adapters.NewsAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment :  MvpAppCompatFragment(), NewsView {


    @InjectPresenter
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun provideNewsPresenter(): NewsPresenter {
        return NewsPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsList.layoutManager = LinearLayoutManager(activity)
        newsPresenter.loadListNews()

    }
    override fun loadingNews(resultNewsList: ArrayList<NewsPojo>) {
        newsList.adapter = NewsAdapter(resultNewsList) {
        }
    }

}
