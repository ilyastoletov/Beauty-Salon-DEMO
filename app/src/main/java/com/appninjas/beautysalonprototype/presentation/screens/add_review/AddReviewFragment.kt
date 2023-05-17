package com.appninjas.beautysalonprototype.presentation.screens.add_review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.FragmentAddReviewBinding

class AddReviewFragment : Fragment() {

    private lateinit var binding: FragmentAddReviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.navigateBackButton.setOnClickListener {
            findNavController().navigate(R.id.reviewFragment)
        }
    }

}