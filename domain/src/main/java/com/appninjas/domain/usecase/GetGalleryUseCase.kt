package com.appninjas.domain.usecase

import com.appninjas.domain.model.Gallery
import com.appninjas.domain.repository.GalleryRepository

class GetGalleryUseCase(private val repository: GalleryRepository) {
    suspend fun invoke(): ArrayList<Gallery> = repository.getGallery()
}