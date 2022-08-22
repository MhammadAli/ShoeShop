package com.example.shoeshop.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeshop.models.Shoe

class MainActivityViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

     var shoes = MutableLiveData<MutableList<Shoe>>()

//    val shoes: LiveData<MutableList<Shoe>>

    init {
        shoes.value = mutableListOf()
        Log.i("MainActivityViewModel", "Created: ")

    }

    override fun onCleared() {
        super.onCleared()

        Log.i("MainActivityViewModel", "onCleared: destroyed")

    }

    fun addShoes(name: String, size: String, company: String, description: String) {
        Log.i("Add new shoes", "addShoes:name $name company $company size $size,desc $description")

        shoes.value?.add(Shoe(name, size, company, description))

        Log.i("size---->", "addShoes: size of shoes is ${shoes.value?.size}")

    }

}