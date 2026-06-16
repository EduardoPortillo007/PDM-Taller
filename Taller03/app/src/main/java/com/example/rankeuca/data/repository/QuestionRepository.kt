package com.example.rankeuca.data.repository
import kotlinx.coroutines.flow.Flow
import com.example.rankeuca.data.modelo.Question

interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun addQuestion(title: String)
    suspend fun deleteQuestion(question: Question)
}