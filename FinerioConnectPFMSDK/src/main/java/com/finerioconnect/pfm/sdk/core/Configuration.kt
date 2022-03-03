package com.finerioconnect.pfm.sdk.core

class Configuration {

    var apiKey = ""
        private set

    var isReadySDK = false
        private set

    fun setApiKey(apiKey: String) = apply {
        this.apiKey = apiKey
    }

    fun setIsReadySDK(isReadySDK: Boolean) = apply {
        this.isReadySDK = isReadySDK
    }

}