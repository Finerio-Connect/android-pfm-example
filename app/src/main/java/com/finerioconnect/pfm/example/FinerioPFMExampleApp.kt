package com.finerioconnect.pfm.example

import android.app.Application
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.sdk.core.FinerioConnectSDK

class FinerioPFMExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //Init UI SDKS
        FinerioConnectSDK.shared.apply {
            apiKey = "ui-api-key"
        }.configure()
        //Init Backend SDKS
        FinerioConnectPFMSDK.shared.apply {
            apiKey = "backend-api-key"
        }.configure()
    }

}