package com.bigmeco.fireflyschoo.models.contracts

interface IAuthModel {
    suspend fun getAuth():String
}