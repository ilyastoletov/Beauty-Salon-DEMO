package com.appninjas.beautysalonprototype.presentation.screens.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appninjas.domain.model.Review
import com.appninjas.domain.usecase.GetReviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(private val getReviewsUseCase: GetReviewsUseCase): ViewModel() {

    private val _reviews: MutableLiveData<ArrayList<Review>> = MutableLiveData()
    val reviews: LiveData<ArrayList<Review>> = _reviews

    fun getReviews() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getReviewsUseCase.invoke()
            _reviews.postValue(result)
        }
    }

}