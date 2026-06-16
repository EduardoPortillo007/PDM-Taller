package com.example.rankeuca.data.database.dao
import androidx.room.Dao
import com.example.rankeuca.data.database.entities.QuestionWithOptions
import androidx.room.Transaction
import com.example.rankeuca.data.database.entities.QuestionEntity
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy

@Dao
interface QuestionDao {

    @Transaction
    @Query("SELECT * FROM questions")
    fun getQuestionsWithOptions(): Flow<List<QuestionWithOptions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Delete
    suspend fun deleteQuestion(question: QuestionEntity)
}