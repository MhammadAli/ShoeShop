package com.example.shoeshop.view_model

import android.util.Log
import androidx.databinding.Bindable
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

    fun addShoes() {
//        Log.i("Add new shoes", "addShoes:name $name company $company size $size,desc $description")

        shoes.value?.add(
            Shoe(
                shoeName.value.toString(),
                shoeSize.value.toString(),
                shoeCompany.value.toString(),
                shoeDescription.value.toString()
            )
        )

        Log.i("name---->", "addShoes: naaaame of shoes is ${shoeName.toString()}")

    }

}