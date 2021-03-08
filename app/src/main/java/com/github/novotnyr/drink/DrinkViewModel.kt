package com.github.novotnyr.drink

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DrinkViewModel(val state: SavedStateHandle) : ViewModel() {
    val drinks: MutableLiveData<List<Drink>>
        get() {
            return state.getLiveData("drinks")
        }

    fun addDrink() {
        val oldDrinks: List<Drink> = state.get("drinks") ?: emptyList()
        val newDrinks = oldDrinks.plus(Drink())
        state.set("drinks", newDrinks)
    }
}