package com.huda.domain.common

import com.huda.domain.common.models.Animal
import com.huda.domain.common.models.AnimalEntity

interface PetsMapper {
    fun fromAnimalList(animals: ArrayList<Animal>?):ArrayList<AnimalEntity>{
        return animals?.map { animalToAnimalEntityMapper(it)} as ArrayList
    }
    fun toAnimalList( animalEntities: ArrayList<AnimalEntity>?):ArrayList<Animal>{
        return animalEntities?.map { animalEntityToAnimalMapper(it) } as ArrayList
    }
    fun animalToAnimalEntityMapper(animal: Animal?):AnimalEntity{
        return AnimalEntity(
            id=animal?.id,
            name = animal?.name,
            organizationId = animal?.organizationId,
            url = animal?.url,
            type = animal?.type,
            species = animal?.species,
            breeds = animal?.breeds,
            colors = animal?.colors,
            age = animal?.age,
            gender = animal?.gender,
            size = animal?.size,
            coat = animal?.coat,
            attributes = animal?.attributes,
            environment = animal?.environment,
            tags = animal?.tags,
            description = animal?.description,
            organizationAnimalId = animal?.organizationAnimalId,
            photos = animal?.photos,
            primaryPhotoCropped = animal?.primaryPhotoCropped,
            status = animal?.status,
            statusChangedAt = animal?.statusChangedAt,
            publishedAt = animal?.publishedAt,
            distance = animal?.distance,
            contact = animal?.contact,
            Links = animal?.Links
        )
    }
    fun animalEntityToAnimalMapper(animalEntity: AnimalEntity?):Animal{
       return Animal(
            id=animalEntity?.id,
            name = animalEntity?.name,
            organizationId = animalEntity?.organizationId,
            url = animalEntity?.url,
            type = animalEntity?.type,
            species = animalEntity?.species,
            breeds = animalEntity?.breeds,
            colors = animalEntity?.colors,
            age = animalEntity?.age,
            gender = animalEntity?.gender,
            size = animalEntity?.size,
            coat = animalEntity?.coat,
            attributes = animalEntity?.attributes,
            environment = animalEntity?.environment,
            tags = animalEntity?.tags,
            description = animalEntity?.description,
            organizationAnimalId = animalEntity?.organizationAnimalId,
            photos = animalEntity?.photos,
            primaryPhotoCropped = animalEntity?.primaryPhotoCropped,
            status = animalEntity?.status,
            statusChangedAt = animalEntity?.statusChangedAt,
            publishedAt = animalEntity?.publishedAt,
            distance = animalEntity?.distance,
            contact = animalEntity?.contact,
            Links = animalEntity?.Links
        )
    }
}