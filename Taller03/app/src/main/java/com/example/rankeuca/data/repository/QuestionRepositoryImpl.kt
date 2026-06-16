package com.example.rankeuca.data.repository
import com.example.rankeuca.data.modelo.Question
import com.example.rankeuca.data.database.dao.QuestionDao
import kotlinx.coroutines.flow.Flow
import com.example.rankeuca.data.database.entities.QuestionEntity
import com.example.rankeuca.data.modelo.toEntity
import kotlinx.coroutines.flow.map
import com.example.rankeuca.data.database.entities.toModel

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }
}