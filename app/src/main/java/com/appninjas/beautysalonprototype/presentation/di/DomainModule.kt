package com.appninjas.beautysalonprototype.presentation.di

import com.appninjas.domain.repository.AppointmentRepository
import com.appninjas.domain.repository.DiscountRepository
import com.appninjas.domain.repository.NewsRepository
import com.appninjas.domain.repository.ReviewsRepository
import com.appninjas.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetDiscountImagesUseCase(repository: DiscountRepository): GetDiscountImagesUseCase {
        return GetDiscountImagesUseCase(repository = repository)
    }

    @Provides
    fun provideGetNewsUseCase(repository: NewsRepository): GetNewsUseCase = GetNewsUseCase(repository)

    @Provides
    fun provideSaveAppointmentUseCase(repository: AppointmentRepository): SaveAppointmentUseCase {
        return SaveAppointmentUseCase(repository)
    }

    @Provides
    fun provideGetServicePriceUseCase(repository: AppointmentRepository): GetServicePriceUseCase {
        return GetServicePriceUseCase(repository)
    }

    @Provides
    fun provideGetReviewsUseCase(repository: ReviewsRepository): GetReviewsUseCase {
        return GetReviewsUseCase(repository)
    }

}