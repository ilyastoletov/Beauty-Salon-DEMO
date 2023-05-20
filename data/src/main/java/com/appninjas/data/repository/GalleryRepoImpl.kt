package com.appninjas.data.repository

import com.appninjas.data.mapper.GalleryMapper
import com.appninjas.domain.model.Gallery
import com.appninjas.domain.repository.GalleryRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class GalleryRepoImpl(private val firebaseFirestore: FirebaseFirestore,
                      private val mapper: GalleryMapper) : GalleryRepository {

    override suspend fun getGallery(): ArrayList<Gallery> {
        val databaseDocuments = firebaseFirestore.collection("gallery").get().await().documents
        return mapper.documentsToGalleryList(databaseDocuments)
    }

}