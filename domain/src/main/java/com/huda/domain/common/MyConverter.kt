package com.huda.domain.common

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.huda.domain.common.models.Attributes
import com.huda.domain.common.models.Breeds
import com.huda.domain.common.models.Colors
import com.huda.domain.common.models.Contact
import com.huda.domain.common.models.Environment
import com.huda.domain.common.models.Links
import com.huda.domain.common.models.Organization
import com.huda.domain.common.models.Photos
import com.huda.domain.common.models.PrimaryPhotoCropped
import com.huda.domain.common.models.Self
import com.huda.domain.common.models.TypeLink

class MyConverter {

    @TypeConverter
    fun jsonToArrayString(value: String?): ArrayList<String>? {
        val arrayType = object : TypeToken<ArrayList<String>?>() {}.type
        return Gson().fromJson(value, arrayType)
    }

    @TypeConverter
    fun arrayStringToJson(array: ArrayList<String>?): String? {
        val gson = Gson()
        return gson.toJson(array)
    }
    @TypeConverter
    fun jsonToArrayPhotos(value: String?): ArrayList<Photos>? {
        val arrayType = object : TypeToken<ArrayList<Photos>?>() {}.type
        return Gson().fromJson(value, arrayType)
    }

    @TypeConverter
    fun arrayPhotosToJson(array: ArrayList<Photos>?): String? {
        val gson = Gson()
        return gson.toJson(array)
    }


    @TypeConverter
    fun jsonToColors(value: String?): Colors? {
        val gson = Gson()
        return gson.fromJson(value, Colors::class.java)
    }

    @TypeConverter
    fun colorsToJson(obj: Colors?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun jsonToAttributes(value: String?): Attributes? {
        return Gson().fromJson(value, Attributes::class.java)
    }

    @TypeConverter
    fun attributesToJson(obj: Attributes?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun jsonToEnvironment(value: String?): Environment? {
        return Gson().fromJson(value, Environment::class.java)
    }

    @TypeConverter
    fun environmentToJson(obj: Environment?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun jsonToPrimaryPhotoCropped(value: String?): PrimaryPhotoCropped? {
        return Gson().fromJson(value, PrimaryPhotoCropped::class.java)
    }

    @TypeConverter
    fun primaryPhotoCroppedToJson(obj: PrimaryPhotoCropped?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun jsonToContact(value: String?): Contact? {
        return Gson().fromJson(value, Contact::class.java)
    }

    @TypeConverter
    fun contactToJson(obj: Contact?): String? {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun jsonToLinks(json: String?): Links? {
        val gson = Gson()
        return gson.fromJson(json, Links::class.java)
    }

    @TypeConverter
    fun linksToJson(links: Links?): String? {
        val gson = Gson()
        return gson.toJson(links)
    }
    @TypeConverter
    fun jsonToSelf(json: String?): Self? {
        val gson = Gson()
        return gson.fromJson(json, Self::class.java)
    }

    @TypeConverter
    fun selfToJson(self: Self?): String? {
        val gson = Gson()
        return gson.toJson(self)
    }
    @TypeConverter
    fun jsonToTypeLink(json: String?): TypeLink? {
        val gson = Gson()
        return gson.fromJson(json, TypeLink::class.java)
    }

    @TypeConverter
    fun typeLinkToJson(typeLink: TypeLink?): String? {
        val gson = Gson()
        return gson.toJson(typeLink)
    }
    @TypeConverter
    fun jsonToOrganization(json: String?): Organization? {
        val gson = Gson()
        return gson.fromJson(json, Organization::class.java)
    }

    @TypeConverter
    fun organizationToJson(organization: Organization?): String? {
        val gson = Gson()
        return gson.toJson(organization)
    }
    @TypeConverter
    fun jsonToBreeds(json: String?): Breeds? {
        val gson = Gson()
        return gson.fromJson(json, Breeds::class.java)
    }

    @TypeConverter
    fun breedsToJson(breeds: Breeds?): String? {
        val gson = Gson()
        return gson.toJson(breeds)
    }

}
