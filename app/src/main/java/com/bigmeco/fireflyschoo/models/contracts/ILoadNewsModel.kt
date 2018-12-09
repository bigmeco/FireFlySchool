package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.NewsPojo

interface ILoadNewsModel {
    fun loadingNews(response: (newsPojos: ArrayList<NewsPojo>) -> Unit)

}