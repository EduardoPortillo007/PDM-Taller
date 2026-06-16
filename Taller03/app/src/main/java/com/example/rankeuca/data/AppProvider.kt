package com.example.rankeuca.data

import android.content.Context
import com.example.rankeuca.data.database.AppDatabase
import com.example.rankeuca.data.repository.OptionRepository
import com.example.rankeuca.data.repository.OptionRepositoryImpl
import com.example.rankeuca.data.repository.QuestionRepository
import com.example.rankeuca.data.repository.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()

    private val questionRepository: QuestionRepository = QuestionRepositoryImpl(questionDao)
    private val optionRepository: OptionRepository = OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository = questionRepository
    fun provideOptionRepository(): OptionRepository = optionRepository
}