package com.example.rankeuca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rankeuca.RankeUcaApplication
import com.example.rankeuca.data.modelo.LugarOption
import com.example.rankeuca.data.repository.OptionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ViewModelCoso(
    private val optionRepository: OptionRepository
) : ViewModel() {

    val option: StateFlow<List<LugarOption>> = optionRepository.getOptions()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun addOption(name: String, imageUrl: String) {
        viewModelScope.launch {
            optionRepository.addOption(name, imageUrl)
        }
    }

    fun deleteOption(option: LugarOption) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    fun vote(optionId: Int) {
        viewModelScope.launch {
            optionRepository.vote(optionId)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RankeUcaApplication
                ViewModelCoso(app.appProvider.provideOptionRepository())
            }
        }
    }
}