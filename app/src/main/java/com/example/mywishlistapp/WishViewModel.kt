package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mywishlistapp.Data.Wish
import com.example.mywishlistapp.Data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescState by mutableStateOf("")

    fun onWishTitleChanged(newString:String){
        wishTitleState=newString
    }

    fun onWishDescChanged(newString:String){
        wishDescState=newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes=wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish=wish)
        }
    }

    fun getWishById(id:Long):Flow<Wish>{
        return wishRepository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish=wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish=wish)
        }
    }

}

