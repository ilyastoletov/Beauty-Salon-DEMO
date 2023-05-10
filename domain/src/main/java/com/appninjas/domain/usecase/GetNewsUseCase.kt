package com.appninjas.domain.usecase

import com.appninjas.domain.model.News
import com.appninjas.domain.repository.NewsRepository

class GetNewsUseCase(private val repository: NewsRepository) {
    suspend fun invoke(): ArrayList<News> = repository.getNews()
}