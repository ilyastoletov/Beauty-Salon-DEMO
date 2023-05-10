package com.appninjas.data.mapper

import com.appninjas.domain.model.News
import com.google.firebase.firestore.DocumentSnapshot

class NewsMapper {

    fun documentsToList(documents: List<DocumentSnapshot>): ArrayList<News> = documents.map { t ->
        News(
            newsTitle = t["title"].toString(),
            newsDate = t["date"].toString(),
            imageUrl = t["imageUrl"].toString()
        )
    }.toCollection(ArrayList())

}