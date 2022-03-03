package com.finerioconnect.core.sdk.core

import com.finerioconnect.core.sdk.BuildConfig
import com.finerioconnect.core.sdk.helpers.logInfo
import com.finerioconnect.core.sdk.shared.enums.Environment
import com.finerioconnect.core.sdk.shared.enums.LogLevel

class FinerioConnectCore private constructor() {

    companion object {
        val shared = FinerioConnectCore()
    }

    private var configuration: Configuration = Configuration()
    private var mixpanelInitialized: Boolean = false

    fun init(configuration: Configuration) = apply {
        this.configuration = configuration
    }

    var logLevel: LogLevel
        get() = configuration.logLevel
        set(value) {
            configuration.setLogLevel(value)
        }

    var environment: Environment
        get() = configuration.environment
        set(value) {
            configuration.setEnvironment(value)
        }

    var isReadySDK: Boolean
        get() = configuration.isReadySDK
        set(value) {
            configuration.setIsReadySDK(value)
        }

    fun configure() {
        logInfo("FinerioConnectCore configured...")
        logInfo("SDK Version: ${BuildConfig.SDK_VERSION}")

        configuration.setIsReadySDK(true)
    }

}