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
import com.huda.data.pet_list.local.TypesDao
import com.huda.domain.common.PetsMapper
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_list.models.Type
import com.huda.domain.pet_list.models.TypeEntity


@HiltAndroidTest
@SmallTest
class TypesDaoTest:PetsMapper{
        @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Inject
    @Named("test_db")
    lateinit var database: AppDatabase
    private lateinit var typesDao: TypesDao
    @Before
    fun setup() {
        hiltRule.inject()
        typesDao = database.getTypesDao()
    }
    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAndGetType() = runBlocking {
        // Given a User that has been inserted into the DB
        val types = arrayListOf(
            Type(name = "cat"),
            Type(name ="dog")
        )

        val typesEntity = types.map { TypeEntity(name = it.name) }.toList()

        typesDao.insertTypes(typesEntity)

        // When getting the Users via the DAO
        val types2 = typesDao.getAnimalTypes()

        // Then the retrieved Users matches the original user object
        assertThat(types2?.size).isEqualTo( 2)
    }

    @Test
    fun deleteTypeTest() = runBlocking {
        // Given a User that has been inserted into the DB
        val types = arrayListOf(
            Type(name = "cat"),
            Type(name ="dog")
        )

        val typesEntity = types.map { TypeEntity(name = it.name) }.toList()

        typesDao.insertTypes(typesEntity)

        // When getting the Users via the DAO
        var types2 = typesDao.getAnimalTypes()

        // Then the retrieved Users matches the original user object
        assertThat(types2?.size).isEqualTo( 2)
         typesDao.deleteTypes()
         types2 = typesDao.getAnimalTypes()
        assertThat(types2?.size).isEqualTo( 0)

    }


}