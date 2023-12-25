package com.huda.petfinderapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.huda.data.common.AppDatabase
import com.huda.data.pet_list.local.PetListDao
import com.huda.domain.common.models.AnimalEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named
import com.google.common.truth.Truth.assertThat
import com.huda.data.pet_details.local.PetDetailsDao
import com.huda.data.pet_list.local.TypesDao
import com.huda.domain.common.PetsMapper
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_list.models.Type
import com.huda.domain.pet_list.models.TypeEntity


@HiltAndroidTest
@SmallTest
class PetDetailsDaoTest:PetsMapper{
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Inject
    @Named("test_db")
    lateinit var database: AppDatabase
    private lateinit var petDetailsDao: PetDetailsDao
    private lateinit var petListDao: PetListDao
    @Before
    fun setup() {
        hiltRule.inject()
        petDetailsDao = database.getPetDetailsDao()
        petListDao = database.getPetListDao()
    }
    @After
    fun tearDown() {
        database.close()
    }


    @Test
    fun getAnimalDetails() = runBlocking {
        // Given a User that has been inserted into the DB
        val animals = arrayListOf(

            Animal(id=1 , name="cat 1", type = "cat"),
            Animal(id=2 , name="Dog 1", type = "dog")
        )
        val animalEntities = fromAnimalList(animals)
        petListDao.insertPets(animalEntities)

        // When getting the Users via the DAO
        val pet = petDetailsDao.getPetById(1)

        // Then the retrieved Users matches the original user object
        assertThat(pet?.name).isEqualTo( "cat 1")
    }
}