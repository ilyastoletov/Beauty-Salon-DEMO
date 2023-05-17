package com.appninjas.domain.repository

import com.appninjas.domain.model.Review

interface ReviewsRepository {
    suspend fun getReviews(): ArrayList<Review>
    suspend fun addReview(review: Review)
}