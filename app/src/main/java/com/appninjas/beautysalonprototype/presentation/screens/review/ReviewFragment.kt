package com.appninjas.beautysalonprototype.presentation.screens.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.FragmentReviewBinding
import com.appninjas.beautysalonprototype.presentation.adapters.ReviewAdapter
import com.appninjas.domain.model.Review
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private val viewModel by viewModels<ReviewViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        viewModel.getReviews()
        viewModel.reviews.observe(viewLifecycleOwner) { reviewsList ->
            val reviewAdapter = ReviewAdapter(reviewsList)
            binding.reviewsRecyclerView.apply {
                adapter = reviewAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        binding.writeReviewButton.setOnClickListener {
            findNavController().navigate(R.id.addReviewFragment)
        }
    }

}