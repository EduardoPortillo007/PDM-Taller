package com.example.rankeuca.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rankeuca.data.modelo.LugarOption

@Entity(tableName = "options")
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val votes: Int = 0,
)

fun OptionEntity.toModel(): LugarOption {
    return LugarOption(
        id = id,
        imageURL = imageUrl,
        name = name,
        votes = votes
    )
}

fun LugarOption.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageURL,
        votes = votes
    )
}