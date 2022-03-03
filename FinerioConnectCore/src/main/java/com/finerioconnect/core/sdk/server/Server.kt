package com.finerioconnect.core.sdk.server

interface Server {

    fun<T: FinerioConnectApi> api(apiClient: Class<T>): T

}