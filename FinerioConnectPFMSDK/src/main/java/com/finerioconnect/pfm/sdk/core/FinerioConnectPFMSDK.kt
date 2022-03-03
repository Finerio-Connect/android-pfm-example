package com.finerioconnect.pfm.sdk.core

import com.finerioconnect.core.sdk.helpers.logInfo
import com.finerioconnect.core.sdk.server.ServerImpl
import com.finerioconnect.pfm.sdk.BuildConfig
import com.finerioconnect.pfm.sdk.server.FinerioPFMApi

class FinerioConnectPFMSDK {

    companion object {
        val shared = FinerioConnectPFMSDK()
    }

    val api: FinerioPFMApi by lazy {
        val serverImpl = ServerImpl(FinerioPFMApi.BASE_URL, true)
        serverImpl.api(FinerioPFMApi::class.java)
    }

    private var configuration: Configuration = Configuration()

    fun init(configuration: Configuration) = apply {
        this.configuration = configuration
    }

    var apiKey: String
        get() = configuration.apiKey
        set(value) {
            configuration.setApiKey(value)
        }

    fun configure() {
        logInfo("FinerioConnectPFMSDK configured...")
        logInfo("SDK Version: ${BuildConfig.SDK_VERSION}")

        configuration.setIsReadySDK(true)
    }

}