package com.huda.petfinderapp.pets_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huda.data.common.SharedPreferencesManager
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_list.models.Pagination
import com.huda.domain.pet_list.models.Type
import com.huda.domain.pet_list.usecases.GetPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.GetTokenUseCase
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsListViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val getTypesUseCase: GetTypesUseCase,
    private val getPetsByTypeUseCase: GetPetsByTypeUseCase,
    private val sharedPref: SharedPreferencesManager
):ViewModel() {
    private val _getTokenResponse = MutableLiveData<String?>()
    val getTokenResponse:LiveData<String?> get() = _getTokenResponse

    private val _getTypesResponse = MutableLiveData<ArrayList<Type>?>()
    val getTypesResponse:LiveData<ArrayList<Type>?> get() = _getTypesResponse

    private val _getPetsByTypeResponse = MutableLiveData<ArrayList<Animal>?>()
    val getPetsByTypeResponse:LiveData<ArrayList<Animal>?> get() = _getPetsByTypeResponse

    private val animals = arrayListOf<Animal>()

    private val _pagination=MutableLiveData<Pagination>()
    val pagination:LiveData<Pagination> get() = _pagination

    fun getToken() {
        viewModelScope.launch {
            val result = getTokenUseCase.invoke()
            sharedPref.saveToken(result?.accessToken)
            _getTokenResponse.postValue(result?.accessToken)
        }
    }
    fun getTypes(){
        viewModelScope.launch {
            val result = getTypesUseCase.invoke()
            result?.types?.add(0,Type(name = "All"))
            _getTypesResponse.postValue(result?.types)
        }
    }
    fun getPetsByType(type:String?=null,page:Int=1) {
        if (page == 1) {
            animals.clear()
        }
        viewModelScope.launch {
            val result = getPetsByTypeUseCase.invoke(type,page)
            if (result?.animals?.isNotEmpty() == true) {
                _pagination.postValue( result.pagination!!)
                appendAnimals(result.animals) 
            } else {
                //handle error
            }
        }
    }

    private fun appendAnimals(data: ArrayList<Animal>) {
        if (!animals.containsAll(data)){
            animals.addAll(data)
        }
        _getPetsByTypeResponse.postValue(animals)
    }

}