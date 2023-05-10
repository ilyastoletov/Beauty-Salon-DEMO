package com.appninjas.data.repository

import com.appninjas.data.mapper.DiscountMapper
import com.appninjas.domain.model.Discount
import com.appninjas.domain.repository.DiscountRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DiscountRepoImpl(private val firebaseStorage: FirebaseFirestore,
                       private val mapper: DiscountMapper) : DiscountRepository {

    override suspend fun getDsicountPictures(): ArrayList<Discount> {
        val discountsDocuments = firebaseStorage.collection("discounts").get().await().documents
        return mapper.discountSnapshotsToModel(discountsDocuments)
    }

}