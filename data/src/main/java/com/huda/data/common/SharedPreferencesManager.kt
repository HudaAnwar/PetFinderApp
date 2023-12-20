package com.huda.data.common

import android.content.SharedPreferences
import com.google.gson.Gson
import java.util.*


class SharedPreferencesManager(private val prefs: SharedPreferences) {

    private val TOKEN = "TOKEN"



    fun getToken(): String = prefs.getString(TOKEN, " ")!!

    fun saveToken(value: String?) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        prefsEditor.putString(TOKEN, value)
        prefsEditor.apply()

    }

}