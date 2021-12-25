package com.miguellugo.mvvmexercise.domain

import com.miguellugo.mvvmexercise.data.QuoteRepository
import com.miguellugo.mvvmexercise.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}