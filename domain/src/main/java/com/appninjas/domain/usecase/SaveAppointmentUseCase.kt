package com.appninjas.domain.usecase

import com.appninjas.domain.model.Appointment
import com.appninjas.domain.repository.AppointmentRepository

class SaveAppointmentUseCase(private val repository: AppointmentRepository) {
    suspend fun invoke(model: Appointment) = repository.saveAppointment(model)
}