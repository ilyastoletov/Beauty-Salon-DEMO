package com.appninjas.beautysalonprototype.presentation.screens.appointment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.FragmentAppointmentBinding
import com.appninjas.beautysalonprototype.presentation.utils.Toast
import com.appninjas.domain.model.Appointment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppointmentFragment : Fragment() {

    private lateinit var binding: FragmentAppointmentBinding
    private val viewModel by viewModels<AppointmentViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAppointmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.saveAppointmentButton.setOnClickListener {
            addAppointment()
        }

        binding.chooseServiceSpinner.onItemSelectedListener = onItemSelected
    }
    private fun addAppointment() {
        if (validateFields()) {
            val nameEditText = binding.nameAppointmentEditText
            val phoneEditText = binding.phoneAppointmentEditText
            val serviceSpinner = binding.chooseServiceSpinner
            val dateEditText = binding.chooseDateEditText

            viewModel.saveAppointment(Appointment(
                name = nameEditText.text.toString(),
                phone = phoneEditText.text.toString(),
                service = serviceSpinner.selectedItem.toString(),
                date = dateEditText.text.toString()
            ))

            Toast.showToast(requireContext(), "Запись добавлена")

            nameEditText.text.clear()
            phoneEditText.text.clear()
            dateEditText.text.clear()
        }
    }

    private fun validateFields(): Boolean = if (binding.nameAppointmentEditText.text.isEmpty() || binding.phoneAppointmentEditText.text.isEmpty() || binding.chooseDateEditText.text.isEmpty()) {
            Toast.showToast(requireContext(), "Вы заполнили не все поля")
            false
        } else if (binding.chooseServiceSpinner.selectedItem == "Выберите услугу") {
            Toast.showToast(requireContext(), "Выберите услугу")
            false
        } else {
            true
        }

    private val onItemSelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val servicesStringArray = resources.getStringArray(R.array.service_name)
            Log.d("Fragment Appoint", "${servicesStringArray[position]}")
            viewModel.getServicePrice(servicesStringArray[position])
            viewModel.service.observe(viewLifecycleOwner) {serviceInfo ->
                binding.servicePriceTextView.text = "Цена услуги: " + serviceInfo.servicePrice + "₽"
                binding.serviceDurationTextView.text = "Время оказания услуги: " + serviceInfo.serviceEstimateTime + " мин."
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

    }


}