package com.appninjas.domain.usecase

import com.appninjas.domain.model.Discount
import com.appninjas.domain.repository.DiscountRepository

class GetDiscountImagesUseCase(private val repository: DiscountRepository) {
    suspend fun invoke(): ArrayList<Discount> = repository.getDsicountPictures()
}