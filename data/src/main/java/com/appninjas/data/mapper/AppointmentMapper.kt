package com.appninjas.data.mapper

import com.appninjas.domain.model.Service
import com.google.firebase.firestore.DocumentSnapshot

class AppointmentMapper {

    fun documentsListToServiceObject(documentsList: List<DocumentSnapshot>, serviceName: String): Service? {
        var service: Service? = null
        for (document in documentsList) {
            if (document.data!!["name"] == serviceName) {
                service = Service(
                    servicePrice = document.data!!["price"].toString(),
                    serviceEstimateTime = document.data!!["estimate_time"].toString()
                )
            }
        }
        return service
    }

}