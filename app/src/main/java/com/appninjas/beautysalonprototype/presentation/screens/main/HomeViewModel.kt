package com.appninjas.beautysalonprototype.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appninjas.domain.model.Discount
import com.appninjas.domain.model.News
import com.appninjas.domain.usecase.GetDiscountImagesUseCase
import com.appninjas.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getDiscountImagesUseCase: GetDiscountImagesUseCase,
                                        private val getNewsUseCase: GetNewsUseCase): ViewModel() {

    private val _discountImages: MutableLiveData<ArrayList<Discount>> = MutableLiveData()
    val discountImages: LiveData<ArrayList<Discount>> = _discountImages

    private val _newsList: MutableLiveData<ArrayList<News>> = MutableLiveData()
    val newsList: LiveData<ArrayList<News>> = _newsList

    fun getDiscountImages() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getDiscountImagesUseCase.invoke()
            _discountImages.postValue(result)
        }
    }

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getNewsUseCase.invoke()
            _newsList.postValue(result)
        }
    }

}