package com.bigmeco.fireflyschoo.presenters.viewInterface

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.bigmeco.fireflyschoo.data.AdressPojo
import com.bigmeco.fireflyschoo.data.InfoPojo


@StateStrategyType(AddToEndStrategy::class)
interface CommunicationView : MvpView {
   fun loadInfo(it: InfoPojo)
   fun loadAdress(it: ArrayList<AdressPojo>)
}