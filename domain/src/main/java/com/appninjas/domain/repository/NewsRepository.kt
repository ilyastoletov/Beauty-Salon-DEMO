package com.appninjas.domain.repository

import com.appninjas.domain.model.News

interface NewsRepository {
    suspend fun getNews(): ArrayList<News>
}