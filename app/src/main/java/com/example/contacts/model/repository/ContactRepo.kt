package com.example.contacts.model.repository

import android.widget.Toast
import com.example.contacts.model.ContactModel
import com.example.contacts.model.data.local.ContactDao
import com.example.contacts.model.data.local.LocalDatabase
import com.example.contacts.model.data.remote.Api
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ContactRepo {
    private val localDaoObj = ContactDao()
    private val apiObj = Api()
    private var localData = mutableListOf<ContactModel>()
    private var remoteData = mutableListOf<ContactModel>()
    suspend fun getContacts(): Flow<MutableList<ContactModel>> {
        val job = CoroutineScope(IO).launch {
            val localDataDefer = async { localDaoObj.fetchData() }
            //val remoteDataDefer = async { apiObj.fetchRemoteContact() }
            localData=localDataDefer.await()
            //remoteData=remoteDataDefer.await()
        }
        job.join()
        return flow{
//            if(localData.size<1)
//            {
//                delay(1000)
//                emit(remoteData)
//                LocalDatabase.contactList+=remoteData
//                LocalDatabase.contactList.distinct()
//            }
//            else
//            {
                emit(localData)
 //           }
        }
    }
}