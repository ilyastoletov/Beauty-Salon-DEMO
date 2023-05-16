package com.appninjas.domain.repository

import com.appninjas.domain.model.Appointment
import com.appninjas.domain.model.Service

interface AppointmentRepository {
    suspend fun saveAppointment(model: Appointment)
    suspend fun getServicePrice(serviceName: String): Service
}