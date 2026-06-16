package com.example.rankeuca.data.repository

import com.example.rankeuca.data.modelo.LugarOption
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(): Flow<List<LugarOption>>
    suspend fun addOption(name: String, imageUrl: String)
    suspend fun deleteOption(option: LugarOption)
    suspend fun vote(optionId: Int)
}