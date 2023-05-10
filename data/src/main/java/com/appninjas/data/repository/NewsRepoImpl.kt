package com.appninjas.data.repository

import com.appninjas.data.mapper.NewsMapper
import com.appninjas.domain.model.News
import com.appninjas.domain.repository.NewsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class NewsRepoImpl(private val firebaseFirestore: FirebaseFirestore,
                   private val mapper: NewsMapper) : NewsRepository {

    override suspend fun getNews(): ArrayList<News> {
        val newsDocuments = firebaseFirestore.collection("news").get().await().documents
        return mapper.documentsToList(newsDocuments)
    }

}