package com.miguellugo.mvvmexercise.data.network

import com.miguellugo.mvvmexercise.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}