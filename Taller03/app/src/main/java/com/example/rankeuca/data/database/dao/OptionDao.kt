package com.example.rankeuca.data.database.dao

import androidx.room.*
import com.example.rankeuca.data.database.entities.OptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Query("SELECT * FROM options")
    fun getAllOptions(): Flow<List<OptionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: OptionEntity)

    @Delete
    suspend fun deleteOption(option: OptionEntity)

    @Query("UPDATE options SET votes = votes + 1 WHERE id = :id")
    suspend fun incrementVote(id: Int)
}