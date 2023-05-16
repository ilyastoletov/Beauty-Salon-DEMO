package com.appninjas.data.repository

import com.appninjas.data.mapper.AppointmentMapper
import com.appninjas.domain.model.Appointment
import com.appninjas.domain.model.Service
import com.appninjas.domain.repository.AppointmentRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

class AppointmentRepoImpl(private val firestore: FirebaseFirestore, private val mapper: AppointmentMapper) : AppointmentRepository {

    override suspend fun saveAppointment(model: Appointment) {
        firestore.collection("appointments").document("${model.phone}_${Random.nextInt()}").set(model)
    }

    override suspend fun getServicePrice(serviceName: String): Service {
        val allDocuments = firestore.collection("services").get().await().documents
        return mapper.documentsListToServiceObject(allDocuments, serviceName)!!
    }

}