package com.appninjas.beautysalonprototype.presentation.screens.appointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appninjas.beautysalonprototype.databinding.FragmentAppointmentBinding

class AppointmentFragment : Fragment() {

    private lateinit var binding: FragmentAppointmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAppointmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}