package com.appninjas.beautysalonprototype.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appninjas.beautysalonprototype.databinding.ReviewItemBinding
import com.appninjas.domain.model.Review

class ReviewAdapter(private val reviewsList: ArrayList<Review>) : RecyclerView.Adapter<ReviewAdapter.Holder>() {

    inner class Holder(view: View, private val binding: ReviewItemBinding) : RecyclerView.ViewHolder(view) {
        fun bind(model: Review) {
            with(binding) {
                reviewerName.text = model.reviewerName
                reviewRatingBar.rating = model.reviewRate.toFloat()
                reviewDate.text = model.reviewDate
                reviewText.text = model.reviewText
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(reviewsList[position])
    }

    override fun getItemCount(): Int = reviewsList.size

}