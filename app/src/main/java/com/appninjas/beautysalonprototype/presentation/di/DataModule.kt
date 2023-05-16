package com.appninjas.beautysalonprototype.presentation.di

import com.appninjas.data.mapper.AppointmentMapper
import com.appninjas.data.mapper.DiscountMapper
import com.appninjas.data.mapper.NewsMapper
import com.appninjas.data.repository.AppointmentRepoImpl
import com.appninjas.data.repository.DiscountRepoImpl
import com.appninjas.data.repository.NewsRepoImpl
import com.appninjas.domain.repository.AppointmentRepository
import com.appninjas.domain.repository.DiscountRepository
import com.appninjas.domain.repository.NewsRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    fun provideDiscountRepository(firestore: FirebaseFirestore): DiscountRepository {
        return DiscountRepoImpl(firebaseStorage = firestore, mapper = DiscountMapper())
    }

    @Provides
    @Singleton
    fun provideNewsRepository(firestore: FirebaseFirestore): NewsRepository {
        return NewsRepoImpl(firebaseFirestore = firestore, mapper = NewsMapper())
    }

    @Provides
    @Singleton
    fun provideAppointmentRepo(firestore: FirebaseFirestore): AppointmentRepository {
        return AppointmentRepoImpl(firestore = firestore, mapper = AppointmentMapper())
    }

}