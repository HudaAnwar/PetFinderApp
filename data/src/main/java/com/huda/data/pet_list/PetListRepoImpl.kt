package com.huda.data.pet_list

import com.huda.data.common.Helper
import com.huda.data.pet_list.local.PetListDao
import com.huda.data.pet_list.local.TypesDao
import com.huda.data.pet_list.remote.PetListServices
import com.huda.domain.common.models.Animal
import com.huda.domain.common.models.AnimalEntity
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_list.models.Type
import com.huda.domain.pet_list.models.TypeEntity
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.common.PetsMapper
import com.huda.domain.common.responses.ErrorResponse
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TypesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Cache

class PetListRepoImpl(
    private val petListServices: PetListServices,
    private val petListDao: PetListDao,
    private val typesDao: TypesDao
) : PetListRepo, PetsMapper {
    override suspend fun getTypes(): BaseResponse<TypesResponse> {
        return try {
           val response = petListServices.getTypes()
            Helper.handleErrorResponse(response, cacheData = ::cacheTypes, true)

       } catch (ex:Exception){
            BaseResponse(
                null,
                ErrorResponse("exception", title = "exception", status = 0, detail = ex.message),
                false
            )
       }
    }

    override suspend fun fetchTypes(): ArrayList<Type> {
        val typesEntities = typesDao.getAnimalTypes()
        return typesEntities?.map { Type(name = it.name) } as ArrayList
    }

    private fun cacheTypes(typesResponse: TypesResponse?,deleteCache: Boolean) {
        val typesEntities = typesResponse?.types?.map { TypeEntity(name = it.name) }?.toList()
        CoroutineScope(Dispatchers.Default).launch {
            if (deleteCache) {
                typesDao.deleteTypes()
            }
            typesDao.insertTypes(typesEntities)
        }
    }

    override suspend fun getPetsByType(
        type: String?,
        page: Int
    ): BaseResponse<AnimalsListResponse> {
        return try {
            val response = petListServices.getPetsByType(type, page)
            val deleteCache = type == null && page == 1
            Helper.handleErrorResponse(response, ::cachePets,deleteCache)
        } catch (ex: Exception) {
            BaseResponse(
                null,
                ErrorResponse("exception", title = "exception", status = 0, detail = ex.message),
                false
            )
        }
    }

    override suspend fun fetchPetsByType(type: String?): ArrayList<Animal> {
        val petsEntities = petListDao.fetchPetsByType(type)
        return toAnimalList(petsEntities as ArrayList<AnimalEntity>)
    }

    private fun cachePets(animalsListResponse: AnimalsListResponse?,deleteCache: Boolean) {
        val animalEntities = fromAnimalList(animalsListResponse?.animals)
        CoroutineScope(Dispatchers.Default).launch {
            if (deleteCache) {
                petListDao.deleteAnimals()
            }
            petListDao.insertPets(animalEntities)
        }
    }
}