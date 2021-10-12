package com.example.contacts.viewModel

import com.example.contacts.model.ContactModel
import com.example.contacts.model.repository.ContactRepo
import kotlinx.coroutines.flow.Flow

class ContactListViewModel {
    private val contactRepoObj = ContactRepo()

    suspend fun getContactListViewModel(): Flow<MutableList<ContactModel>> {
        return contactRepoObj.getContacts()
    }

}