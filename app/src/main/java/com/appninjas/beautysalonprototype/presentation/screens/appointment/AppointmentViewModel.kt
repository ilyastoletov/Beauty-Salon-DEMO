package com.appninjas.beautysalonprototype.presentation.screens.appointment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appninjas.domain.model.Appointment
import com.appninjas.domain.model.Service
import com.appninjas.domain.usecase.GetServicePriceUseCase
import com.appninjas.domain.usecase.SaveAppointmentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppointmentViewModel @Inject constructor(private val saveAppointmentUseCase: SaveAppointmentUseCase,
                                               private val getServicePriceUseCase: GetServicePriceUseCase) : ViewModel() {

    private val _service: MutableLiveData<Service> = MutableLiveData()
    val service: LiveData<Service> = _service

    fun saveAppointment(model: Appointment) {
        viewModelScope.launch(Dispatchers.IO) {
            saveAppointmentUseCase.invoke(model)
        }
    }

    fun getServicePrice(serviceName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getServicePriceUseCase.invoke(serviceName)
            _service.postValue(result)
        }
    }

}