package com.appninjas.beautysalonprototype.presentation.screens.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appninjas.beautysalonprototype.databinding.FragmentReviewBinding

class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

}