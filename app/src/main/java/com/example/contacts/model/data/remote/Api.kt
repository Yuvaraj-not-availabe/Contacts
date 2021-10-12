package com.example.contacts.model.data.remote

import com.example.contacts.model.ContactModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.FileReader
import java.io.IOException


class Api {
    private val gson = Gson()
    private fun String.getJsonDataFromRemote(): String? {
        val jsonString: String
        try {
            jsonString = FileReader(this).use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun parseRemote(): MutableList<ContactModel> {
        val fileName =
            "/Users/yuvaraj-pt4283/AndroidStudioProjects/Contacts/app/src/main/java/com/example/contacts/model/data/sample.json"
        val classType = object : TypeToken<List<ContactModel>>() {}.type
        val jsonData = fileName.getJsonDataFromRemote()
        return gson.fromJson(jsonData, classType)
    }


    suspend fun fetchRemoteContact(): MutableList<ContactModel> {
        var contactList = mutableListOf<ContactModel>()
        val job = CoroutineScope(IO).launch {
            contactList = parseRemote()
        }
        job.join()
        return contactList
    }
}