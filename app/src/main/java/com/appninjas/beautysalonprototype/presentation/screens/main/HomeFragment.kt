package com.appninjas.beautysalonprototype.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appninjas.beautysalonprototype.databinding.FragmentHomeBinding
import com.appninjas.beautysalonprototype.presentation.adapters.DiscountAdapter
import com.appninjas.domain.model.Discount

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val testDiscountList: ArrayList<Discount> = arrayListOf(
            Discount("https://cdnstatic.rg.ru/resize800x533/uploads/photogallery/2023/05/07/2023-05-07-131822_c26.jpg"),
            Discount("https://avatars.mds.yandex.net/get-altay/176734/2a000001658783ac951caa06a6c3cdc05ba2/XXXL"),
            Discount("https://telegra.ph/file/c9770e4fa3f3f0cc94a4f.jpg"),
            Discount("https://avatars.mds.yandex.net/i?id=d6996be0ec94c56947b82fc79ce136dd0087e994-8277774-images-thumbs&n=13")
        )

        val discountAdapter = DiscountAdapter(testDiscountList)
        binding.discountsRecyclerView.apply {
            adapter = discountAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }

}