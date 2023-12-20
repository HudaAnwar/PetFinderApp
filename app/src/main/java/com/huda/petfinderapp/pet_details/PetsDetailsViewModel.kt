package com.huda.petfinderapp.pet_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.data.common.SharedPreferencesManager
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_details.usecases.GetPetDetailsUseCase
import com.huda.domain.pet_list.models.Pagination
import com.huda.domain.pet_list.models.Type
import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.usecases.GetPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.GetTokenUseCase
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsDetailsViewModel @Inject constructor(private val getPetDetailsUseCase: GetPetDetailsUseCase):ViewModel() {

    private val _getPetResponse = MutableLiveData<Animal?>()
    val getPetResponse:LiveData<Animal?> get() = _getPetResponse


    fun getPet(petId:Int) {
        viewModelScope.launch {
            val result = getPetDetailsUseCase.invoke(petId)
            if (result?.animal!=null) {
                _getPetResponse.postValue(result.animal)
            } else {
                //handle error
            }
        }
    }
}