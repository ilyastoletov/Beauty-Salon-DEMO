package com.appninjas.domain.usecase

import com.appninjas.domain.model.Review
import com.appninjas.domain.repository.ReviewsRepository

class AddReviewUseCase(private val repository: ReviewsRepository) {
    suspend fun invoke(review: Review) = repository.addReview(review)
}