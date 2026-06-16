package com.example.rankeuca.data

import android.content.Context
import com.example.rankeuca.data.database.AppDatabase
import com.example.rankeuca.data.repository.OptionRepository
import com.example.rankeuca.data.repository.OptionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository = OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository = optionRepository
}