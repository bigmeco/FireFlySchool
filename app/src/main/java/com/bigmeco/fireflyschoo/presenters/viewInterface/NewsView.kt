package com.bigmeco.fireflyschoo.presenters.viewInterface

import com.arellomobile.mvp.MvpView
import com.bigmeco.fireflyschoo.data.NewsPojo

interface NewsView:MvpView {
    fun loadingNews(newsList:  ArrayList<NewsPojo>)
}