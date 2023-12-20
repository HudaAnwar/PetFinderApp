package com.huda.petfinderapp.pets_list

import com.huda.domain.pet_list.usecases.GetPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.GetTokenUseCase
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PetsListViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val getTypesUseCase: GetTypesUseCase,
    private val getPetsByTypeUseCase: GetPetsByTypeUseCase
) {

}