package com.appninjas.domain.usecase

import com.appninjas.domain.model.Review
import com.appninjas.domain.repository.ReviewsRepository

class GetReviewsUseCase(private val repository: ReviewsRepository) {
    suspend fun invoke(): ArrayList<Review> = repository.getReviews()
}