package com.appninjas.beautysalonprototype.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appninjas.beautysalonprototype.databinding.GalleryItemBinding
import com.appninjas.domain.model.Gallery
import com.squareup.picasso.Picasso

class GalleryAdapter(private val galleryList: ArrayList<Gallery>, private val photoClickListener: PhotoClickListener) : RecyclerView.Adapter<GalleryAdapter.Holder>() {

    inner class Holder(view: View, private val binding: GalleryItemBinding) : RecyclerView.ViewHolder(view) {
        fun bind(model: Gallery) {
            with(binding) {
                Picasso.get().load(model.photoUrl).into(masterPhoto)
                masterName.text = model.name
                masterPhoto.setOnClickListener {
                    photoClickListener.onClick(model.photoUrl)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = GalleryItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(galleryList[position])
    }

    interface PhotoClickListener {
        fun onClick(photoUrl: String)
    }

    override fun getItemCount(): Int = galleryList.size

}