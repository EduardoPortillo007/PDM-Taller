package com.example.rankeuca.data.repository

import com.example.rankeuca.data.modelo.LugarOption
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(questionId: Int): Flow<List<LugarOption>>
    suspend fun addOption(name: String, imageUrl: String, questionId: Int)
    suspend fun deleteOption(option: LugarOption)
    suspend fun vote(optionId: Int)
}