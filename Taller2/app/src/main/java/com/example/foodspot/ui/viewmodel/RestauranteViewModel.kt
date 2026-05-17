package com.example.foodspot.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodspot.data.model.Restaurant
import com.example.foodspot.data.repository.sampleRestaurants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantViewModel : ViewModel() {
    private val _restaurants = MutableStateFlow<List<Restaurant>>(sampleRestaurants)
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

}