package com.appninjas.domain.repository

import com.appninjas.domain.model.Discount

interface DiscountRepository {
    suspend fun getDsicountPictures(): ArrayList<Discount>
}