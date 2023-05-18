package com.appninjas.data.repository

import com.appninjas.data.mapper.ReviewMapper
import com.appninjas.domain.model.Review
import com.appninjas.domain.repository.ReviewsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

class ReviewRepoImpl(private val firestore: FirebaseFirestore, private val mapper: ReviewMapper) : ReviewsRepository {

    override suspend fun addReview(review: Review) {
        firestore.collection("reviews")
            .document("${review.reviewDate}_${Random.nextInt()}")
            .set(review)
    }

    override suspend fun getReviews(): ArrayList<Review> {
        val documentsList = firestore.collection("reviews").get().await().documents
        return mapper.documentsToReviewList(documentsList)
    }

}