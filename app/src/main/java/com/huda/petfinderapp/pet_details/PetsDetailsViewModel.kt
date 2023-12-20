package com.huda.petfinderapp.pet_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.data.common.SharedPreferencesManager
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_details.usecases.GetPetDetailsUseCase
import com.huda.domain.token.usecases.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsDetailsViewModel @Inject constructor(
    private val getPetDetailsUseCase: GetPetDetailsUseCase,
    private val getTokenUseCase: GetTokenUseCase,
    private val sharedPref: SharedPreferencesManager
) :
    ViewModel() {

    private val _getPetResponse = MutableLiveData<Animal?>()
    val getPetResponse: LiveData<Animal?> get() = _getPetResponse
    private val _errorResponse = MutableLiveData<String?>()
    val errorResponse: LiveData<String?> get() = _errorResponse

    fun getPet(petId: Int) {
        viewModelScope.launch {
            val result = getPetDetailsUseCase.invoke(petId)
            if (result?.response != null) {
                _getPetResponse.postValue(result.response!!.animal)

            } else {
                if (result?.errorResponse?.title == "Unauthorized") {
                    getToken()
                    getPet(petId)
                }
                _errorResponse.postValue(result?.errorResponse?.detail)
            }
        }
    }

    private suspend fun getToken() {
        val result = getTokenUseCase.invoke()
        if (result?.response != null) {
            sharedPref.saveToken(result.response?.accessToken)
        } else {
            _errorResponse.postValue(result?.errorResponse?.detail)
        }
    }
}