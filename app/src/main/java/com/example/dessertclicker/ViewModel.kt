package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.model.Dessert
import androidx.compose.runtime.mutableStateOf


class DessertClickerViewModel : ViewModel() {
    var revenue = mutableStateOf(0)
    var dessertsSold = mutableStateOf(0)
    var currentDessertIndex = mutableStateOf(0)
    lateinit var currentDessert: Dessert
    fun initialize(desserts: List<Dessert>) {
        currentDessert = desserts[currentDessertIndex.value]
    }


    fun onDessertClicked(desserts: List<Dessert>) {
        revenue.value += currentDessert.price
        dessertsSold.value++

        // Show the next dessert
        for (dessert in desserts) {
            if (dessertsSold.value >= dessert.startProductionAmount) {
                currentDessert = dessert
            } else {
                break
            }
        }
    }
}