package com.example.rankeuca.data.database.entities
import androidx.room.Embedded
import com.example.rankeuca.data.modelo.Question
import androidx.room.Relation
data class QuestionWithOptions(
    @Embedded val question: QuestionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "questionId"
    )
    val options: List<OptionEntity>
)

fun QuestionWithOptions.toModel(): Question {
    return Question(
        id = question.id,
        title = question.title,
        optionCount = options.size,
    )
}