package com.example.m07accesibilidad

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<Product>>(mutableListOf())
    val cartItems: LiveData<MutableList<Product>> get() = _cartItems

    fun addProduct(product: Product) {
        val currentList = _cartItems.value ?: mutableListOf()
        currentList.add(product)
        _cartItems.value = currentList
    }

    fun makePayment() {
        _cartItems.value?.clear()
    }

    fun removeProduct(product: Product) {
        val currentList = _cartItems.value ?: mutableListOf()
        currentList.remove(product)
        _cartItems.value = currentList // Actualiza la lista
    }



}


