package com.appninjas.beautysalonprototype.presentation.screens.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.FragmentGalleryBinding
import com.appninjas.beautysalonprototype.presentation.adapters.GalleryAdapter
import com.appninjas.beautysalonprototype.presentation.screens.photo_viewer.ViewPhotoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private val viewModel by viewModels<GalleryViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        viewModel.getGallery()
        viewModel.galleryList.observe(viewLifecycleOwner) {galleryList ->
            val galleryAdapter = GalleryAdapter(galleryList, imageClickListener)
            binding.galleryRecyclerView.apply {
                adapter = galleryAdapter
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }
    }

    private val imageClickListener = object : GalleryAdapter.PhotoClickListener {
        override fun onClick(photoUrl: String) {
            val intent = Intent(requireActivity(), ViewPhotoActivity::class.java)
            intent.putExtra("imageUrl", photoUrl)
            startActivity(intent)
        }
    }

}