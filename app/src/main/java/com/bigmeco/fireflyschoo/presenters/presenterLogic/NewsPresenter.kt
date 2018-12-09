package com.bigmeco.fireflyschoo.presenters.presenterLogic

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.contracts.ILoadNewsModel
import com.bigmeco.fireflyschoo.models.implementation.LoadNewsModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.NewsView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@InjectViewState
class NewsPresenter : MvpPresenter<NewsView>() {
    fun loadListNews() {
        LoadNewsModel().loadingNews{
            viewState.loadingNews(it)
        }


    }
}