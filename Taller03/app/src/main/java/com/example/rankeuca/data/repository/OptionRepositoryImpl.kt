package com.example.rankeuca.data.repository

import com.example.rankeuca.data.database.dao.OptionDao
import com.example.rankeuca.data.database.entities.OptionEntity
import com.example.rankeuca.data.database.entities.toModel
import com.example.rankeuca.data.database.entities.toEntity
import com.example.rankeuca.data.modelo.LugarOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao: OptionDao
) : OptionRepository {

    override fun getOptions(questionId: Int): Flow<List<LugarOption>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(name: String, imageUrl: String, questionId: Int) {
        optionDao.insertOption(OptionEntity(name = name, imageUrl = imageUrl, questionId = questionId))
    }

    override suspend fun deleteOption(option: LugarOption) {
        optionDao.deleteOption(option.toEntity())
    }

    override suspend fun vote(optionId: Int) {
        optionDao.incrementVote(optionId)
    }
}