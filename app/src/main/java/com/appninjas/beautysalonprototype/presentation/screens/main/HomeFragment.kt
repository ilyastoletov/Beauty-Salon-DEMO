package com.appninjas.beautysalonprototype.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.appninjas.beautysalonprototype.databinding.FragmentHomeBinding
import com.appninjas.beautysalonprototype.presentation.adapters.DiscountAdapter
import com.appninjas.beautysalonprototype.presentation.adapters.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {

        viewModel.getDiscountImages()
        viewModel.discountImages.observe(viewLifecycleOwner) {discountList ->
            val discountAdapter = DiscountAdapter(discountList)
            binding.discountsRecyclerView.apply {
                adapter = discountAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }

        viewModel.getNews()
        viewModel.newsList.observe(viewLifecycleOwner) {newsList ->
            val newsAdapter = NewsAdapter(newsList)
            binding.newsRecyclerView.apply {
                adapter = newsAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

    }

}