package com.miguellugo.mvvmexercise.data

import com.miguellugo.mvvmexercise.data.model.QuoteModel
import com.miguellugo.mvvmexercise.data.model.QuoteProvider
import com.miguellugo.mvvmexercise.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}