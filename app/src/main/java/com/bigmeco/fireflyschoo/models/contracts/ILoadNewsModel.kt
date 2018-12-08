package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.NewsPojo

interface ILoadNewsModel {
    suspend fun loadingNews(): ArrayList<NewsPojo>

}