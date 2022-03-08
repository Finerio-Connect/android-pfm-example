package com.finerioconnect.pfm.sdk.server

import com.finerioconnect.core.sdk.models.*
import com.finerioconnect.core.sdk.models.requests.*
import com.finerioconnect.core.sdk.models.responses.*
import com.finerioconnect.core.sdk.server.FinerioConnectApi
import io.reactivex.rxjava3.core.Observable
import retrofit2.adapter.rxjava3.Result
import retrofit2.http.*

interface FinerioPFMApi: FinerioConnectApi {

    companion object {
        const val BASE_URL = "https://pfm-api-sandbox.finerioconnect.com/"
    }

    // Transaction services

    @GET("cc6ba13e82dbaf4505ae7324c0c151aa53622329")
    fun getTransactions(
        @HeaderMap headers: Map<String, String>,
        @Query("accountId") accountId: Int,
        @QueryMap options: Map<String, String>
    ): Observable<Result<FCTransactionsResponse>>

    @GET("cc6ba13e82dbaf4505ae7324c0c151aa53622329/{id}")
    fun getTransaction(
        @HeaderMap headers: Map<String, String>,
        @Path("id") transactionId: Int
    ): Observable<Result<FCTransaction>>

    @POST("cc6ba13e82dbaf4505ae7324c0c151aa53622329")
    fun createTransaction(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateTransactionRequest
    ): Observable<Result<FCTransaction>>

    @PUT("cc6ba13e82dbaf4505ae7324c0c151aa53622329/{id}")
    fun updateTransaction(
        @HeaderMap headers: Map<String, String>,
        @Path("id") transactionId: Int,
        @Body request: FCUpdateTransactionRequest
    ): Observable<Result<FCTransaction>>

    @DELETE("cc6ba13e82dbaf4505ae7324c0c151aa53622329/{id}")
    fun deleteTransaction(
        @HeaderMap headers: Map<String, String>,
        @Path("id") transactionId: Int
    ): Observable<Result<Unit>>

    // Account services

    @GET("ddde998e39f1892650715c23817c09e102ac1ec4")
    fun getAccounts(
        @HeaderMap headers: Map<String, String>,
        @Query("userId") userId: Int,
        @Query("cursor") cursor: Int
    ): Observable<Result<FCAccountsResponse>>

    @GET("ddde998e39f1892650715c23817c09e102ac1ec4/{id}")
    fun getAccount(
        @HeaderMap headers: Map<String, String>,
        @Path("id") accountId: Int
    ): Observable<Result<FCAccount>>

    @POST("ddde998e39f1892650715c23817c09e102ac1ec4")
    fun createAccount(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateAccountRequest
    ): Observable<Result<FCAccount>>

    @PUT("ddde998e39f1892650715c23817c09e102ac1ec4/{id}")
    fun updateAccount(
        @HeaderMap headers: Map<String, String>,
        @Path("id") accountId: Int,
        @Body request: FCUpdateAccountRequest
    ): Observable<Result<FCAccount>>

    @DELETE("ddde998e39f1892650715c23817c09e102ac1ec4/{id}")
    fun deleteAccount(
        @HeaderMap headers: Map<String, String>,
        @Path("id") accountId: Int
    ): Observable<Result<Unit>>

    //Budgets service

    @POST("205e33ba58fee3ee07ef1a8cccc4ba9b97d3caf2")
    fun createBudget(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateBudgetRequest
    ): Observable<Result<FCBudget>>

    @GET("205e33ba58fee3ee07ef1a8cccc4ba9b97d3caf2")
    fun getBudgets(
        @HeaderMap headers: Map<String, String>,
        @Query("userId") userId: Int,
        @Query("cursor") cursor: Int?
    ): Observable<Result<FCBudgetsResponse>>

    @GET("205e33ba58fee3ee07ef1a8cccc4ba9b97d3caf2/{id}")
    fun getBudget(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<FCBudget>>

    @PUT("205e33ba58fee3ee07ef1a8cccc4ba9b97d3caf2/{id}")
    fun updateBudget(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int,
        @Body request: FCUpdateBudgetRequest
    ): Observable<Result<FCBudget>>

    @DELETE("205e33ba58fee3ee07ef1a8cccc4ba9b97d3caf2/{id}")
    fun deleteBudget(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<Unit>>

    //Summary service

    @GET("f4f8faab7f280eaf05fc812c285c7902f6a6d05a")
    fun getSummary(
        @HeaderMap headers: Map<String, String>,
        @Query("userId") userId: Int,
        @Query("accountId") accountId: Int?,
        @Query("dateFrom") dateFrom: Long?,
        @Query("dateTo") dateTo: Long?,
    ): Observable<Result<FCSummaryResponse>>

    //Analysis service

    @GET("824aa15eed3dfc815bd0bec5c34354d471a44557")
    fun getAnalysis(
        @HeaderMap headers: Map<String, String>,
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Observable<Result<FCAnalysisResponse>>

    //Categories services

    @GET("b07db4dc65bda086ae37ffeb8e03a126b18ffa6f")
    fun getCategories(
        @HeaderMap headers: Map<String, String>,
        @QueryMap options: Map<String, String>
    ): Observable<Result<FCCategoriesResponse>>

    @GET("b07db4dc65bda086ae37ffeb8e03a126b18ffa6f/{id}")
    fun getCategory(
        @HeaderMap headers: Map<String, String>,
        @Path("id") categoryId: Int
    ): Observable<Result<FCCategory>>

    @POST("b07db4dc65bda086ae37ffeb8e03a126b18ffa6f")
    fun createCategory(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateCategoryRequest
    ): Observable<Result<FCCategory>>

    @PUT("b07db4dc65bda086ae37ffeb8e03a126b18ffa6f/{id}")
    fun updateCategory(
        @HeaderMap headers: Map<String, String>,
        @Path("id") categoryId: Int,
        @Body request: FCUpdateCategoryRequest
    ): Observable<Result<FCCategory>>

    @DELETE("b07db4dc65bda086ae37ffeb8e03a126b18ffa6f/{id}")
    fun deleteCategory(
        @HeaderMap headers: Map<String, String>,
        @Path("id") categoryId: Int
    ): Observable<Result<Unit>>

    //Financial service

    @POST("9d83483fad268a4d685f3e60c01ab804121113a9")
    fun createFinancialEntity(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateFinancialEntityRequest
    ): Observable<Result<FCFinancialEntity>>

    @GET("9d83483fad268a4d685f3e60c01ab804121113a9")
    fun getFinancialEntities(
        @HeaderMap headers: Map<String, String>,
        @Query("cursor") cursor: Int?
    ): Observable<Result<FCFinancialEntitiesResponse>>

    @GET("9d83483fad268a4d685f3e60c01ab804121113a9/{id}")
    fun getFinancialEntity(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<FCFinancialEntity>>

    @PUT("9d83483fad268a4d685f3e60c01ab804121113a9/{id}")
    fun updateFinancialEntity(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int,
        @Body request: FCUpdateFinancialEntityRequest
    ): Observable<Result<FCFinancialEntity>>

    @DELETE("9d83483fad268a4d685f3e60c01ab804121113a9/{id}")
    fun deleteFinancialEntity(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<Unit>>

    //Users service

    @POST("00611e5e13b4853ed35571e62220ab1542c3678c")
    fun createUser(
        @HeaderMap headers: Map<String, String>,
        @Body request: FCCreateUserRequest
    ): Observable<Result<FCUser>>

    @GET("00611e5e13b4853ed35571e62220ab1542c3678c")
    fun getUsers(
        @HeaderMap headers: Map<String, String>,
        @Query("cursor") cursor: Int?
    ): Observable<Result<FCUsersResponse>>

    @GET("00611e5e13b4853ed35571e62220ab1542c3678c/{id}")
    fun getUser(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<FCUser>>

    @PUT("00611e5e13b4853ed35571e62220ab1542c3678c/{id}")
    fun updateUser(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int,
        @Body request: FCUpdateUserRequest
    ): Observable<Result<FCUser>>

    @DELETE("00611e5e13b4853ed35571e62220ab1542c3678c/{id}")
    fun deleteUser(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Int
    ): Observable<Result<Unit>>
}