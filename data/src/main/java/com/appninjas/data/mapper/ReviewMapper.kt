package com.appninjas.data.mapper

import com.appninjas.domain.model.Review
import com.google.firebase.firestore.DocumentSnapshot

class ReviewMapper {

    fun documentsToReviewList(documentList: List<DocumentSnapshot>): ArrayList<Review> = documentList.map { t ->
        Review(
            reviewerName = t["name"].toString(),
            reviewDate = t["date"].toString(),
            reviewRate = t["rate"].toString().toInt(),
            reviewText = t["review"].toString()
        )
    }.toCollection(ArrayList())

}