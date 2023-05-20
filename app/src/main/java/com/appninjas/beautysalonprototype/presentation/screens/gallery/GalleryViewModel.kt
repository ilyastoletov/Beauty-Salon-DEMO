package com.appninjas.beautysalonprototype.presentation.screens.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appninjas.domain.model.Gallery
import com.appninjas.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val getGalleryUseCase: GetGalleryUseCase): ViewModel() {

    private val _galleryList: MutableLiveData<ArrayList<Gallery>> = MutableLiveData()
    val galleryList: LiveData<ArrayList<Gallery>> = _galleryList

    fun getGallery() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getGalleryUseCase.invoke()
            _galleryList.postValue(result)
        }
    }

}