package com.finerioconnect.pfm.sdk.base

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCErrorResponse
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.squareup.moshi.Moshi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.adapter.rxjava3.Result

abstract class BaseDatasourceImpl<R>: BaseDatasource {

    private var disposable: Disposable? = null

    private val moshi: Moshi by lazy { Moshi.Builder().build() }

    protected var success: ((R) -> Unit)? = null

    protected var error: ((List<FCError>) -> Unit)? = null

    protected var serverError: ((Throwable) -> Unit)? = null

    protected fun Observable<Result<R>>.request() {
        disposable = this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ manageResponse(it) }, { serverError?.invoke(it) })
    }

    private fun manageResponse(result: Result<R>){
        val response = result.response()
        if(result.isError || response == null){
            result.error()?.let { serverError?.invoke(it) }
            return
        }
        if(response.isSuccessful && response.body() != null){
            success?.invoke(response.body()!!)
        } else if(response.code() == 204) {
            success?.invoke(Any() as R)
        } else if(response.code() == 400 || response.code() == 404){
            val errorString = response.errorBody()?.byteString()?.utf8()?:""
            val errorResponse = moshi.adapter(FCErrorResponse::class.java).fromJson(errorString)
            error?.invoke(errorResponse!!.errors)
        } else {
            serverError?.invoke(Throwable(response.message()))
        }
    }

    override fun cancel() {
        disposable?.dispose()
    }

    protected fun getJsonHeaders(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers["Content-Type"] = "application/json"
        headers["Api-Key"] = FinerioConnectPFMSDK.shared.apiKey
        return headers
    }

    protected fun getHeaders(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers["Api-Key"] = FinerioConnectPFMSDK.shared.apiKey
        return headers
    }

}