package com.finerioconnect.core.sdk.core

import com.finerioconnect.core.sdk.shared.enums.Environment
import com.finerioconnect.core.sdk.shared.enums.LogLevel

class Configuration {

    // MARK: Global Constants

    companion object {
        const val ERROR_DOMAIN = "com.finerioconnect.network"
        const val FINERIO_CONNECT_ERROR_KEY = "FinerioConnectErrorKey"
        const val FINERIO_CONNECT_ERROR_DEBUG_KEY = "FinerioConnectErrorDebugKey"
    }

    // MARK: Global Variables

    var logLevel: LogLevel = LogLevel.INFO
        private set
    var environment: Environment = Environment.SANDBOX
        private set
    var isReadySDK = false
        private set

    fun setLogLevel(logLevel: LogLevel) = apply {
        this.logLevel = logLevel
    }

    fun setEnvironment(environment: Environment) = apply {
        this.environment = environment
    }

    fun setIsReadySDK(isReadySDK: Boolean) = apply {
        this.isReadySDK = isReadySDK
    }

}