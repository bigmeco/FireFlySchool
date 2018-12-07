package com.bigmeco.fireflyschoo.presenters.viewInterface

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndStrategy::class)
interface NavigationView:MvpView {
}