package com.appninjas.domain.repository

import com.appninjas.domain.model.Gallery

interface GalleryRepository {
    suspend fun getGallery(): ArrayList<Gallery>
}