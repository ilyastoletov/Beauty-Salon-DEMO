package com.appninjas.domain.usecase

import com.appninjas.domain.repository.AppointmentRepository

class GetServicePriceUseCase(private val repository: AppointmentRepository) {
    suspend fun invoke(serviceName: String) = repository.getServicePrice(serviceName)
}