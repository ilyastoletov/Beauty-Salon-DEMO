package com.appninjas.data.mapper

import com.appninjas.domain.model.Discount
import com.google.firebase.firestore.DocumentSnapshot

class DiscountMapper {

    fun discountSnapshotsToModel(snapshotList: List<DocumentSnapshot>): ArrayList<Discount> = snapshotList.map {
            t -> Discount(discountImageUrl = t["imageUrl"].toString())
    }.toCollection(ArrayList())

}