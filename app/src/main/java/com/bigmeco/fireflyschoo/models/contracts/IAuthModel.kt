package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.presenters.presenterLogic.SplashPresenter

interface IAuthModel {
     fun getAuth(response: (uid: String) -> Unit)
}