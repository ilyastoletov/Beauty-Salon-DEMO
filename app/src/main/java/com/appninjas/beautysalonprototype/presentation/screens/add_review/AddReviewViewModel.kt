package com.appninjas.beautysalonprototype.presentation.screens.add_review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appninjas.domain.model.Review
import com.appninjas.domain.usecase.AddReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddReviewViewModel @Inject constructor(private val addReviewUseCase: AddReviewUseCase): ViewModel() {

    fun addReview(review: Review) {
        viewModelScope.launch(Dispatchers.IO) {
            addReviewUseCase.invoke(review)
        }
    }

}