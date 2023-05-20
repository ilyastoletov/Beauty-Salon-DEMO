package com.appninjas.data.mapper

import com.appninjas.domain.model.Gallery
import com.google.firebase.firestore.DocumentSnapshot

class GalleryMapper {

    fun documentsToGalleryList(documents: List<DocumentSnapshot>): ArrayList<Gallery> = documents.map { t ->
        Gallery(
            name = t["name"].toString(),
            photoUrl = t["photoUrl"].toString()
        )
    }.toCollection(ArrayList())

}