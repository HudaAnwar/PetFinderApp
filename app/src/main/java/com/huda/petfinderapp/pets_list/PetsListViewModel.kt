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
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import com.huda.domain.token.usecases.GetTokenUseCase
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

    private val _errorResponse = MutableLiveData<String?>()
    val errorResponse:LiveData<String?> get() = _errorResponse

    private val animals = arrayListOf<Animal>()

    private val _pagination=MutableLiveData<Pagination>()
    val pagination:LiveData<Pagination> get() = _pagination

    suspend fun getToken() {
        val result = getTokenUseCase.invoke()
        if (result?.response != null) {
            sharedPref.saveToken(result.response?.accessToken)
        } else {
            _errorResponse.postValue(result?.errorResponse?.detail)
        }
    }
    fun getTypes(){
        viewModelScope.launch {
            val result = getTypesUseCase.invoke()
            if (result?.response!=null) {
                result.response?.types?.add(0,Type(name = "All"))
                _getTypesResponse.postValue(result.response?.types)
            }else{
                if (result?.errorResponse?.title=="Unauthorized"){
                    getToken()
                    getTypes()
                }
                _errorResponse.postValue(result?.errorResponse?.detail)
            }
        }
    }
    fun getPetsByType(type:String?=null,page:Int=1) {
        if (page == 1) {
            animals.clear()
        }
        viewModelScope.launch {
            val result = getPetsByTypeUseCase.invoke(type,page)
            if (result?.response!=null) {
                _pagination.postValue( result.response?.pagination!!)
                appendAnimals(result.response!!.animals)
            }else{
                if (result?.errorResponse?.title=="Unauthorized"){
                    getToken()
                    getPetsByType(type,page)
                }
                _errorResponse.postValue(result?.errorResponse?.detail)
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