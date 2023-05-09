package com.appninjas.beautysalonprototype.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appninjas.beautysalonprototype.databinding.DiscountItemBinding
import com.appninjas.domain.model.Discount
import com.squareup.picasso.Picasso

class DiscountAdapter(private val discountList: ArrayList<Discount>) : RecyclerView.Adapter<DiscountAdapter.Holder>() {

    inner class Holder(view: View, private val binding: DiscountItemBinding) : RecyclerView.ViewHolder(view) {
        fun bind(model: Discount) {
            Picasso.get().load(model.discountImageUrl).into(binding.discountImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DiscountItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(discountList[position])
    }

    override fun getItemCount(): Int = discountList.size

}