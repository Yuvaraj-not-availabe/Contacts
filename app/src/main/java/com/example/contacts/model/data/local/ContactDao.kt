package com.example.contacts.model.data.local

import com.example.contacts.model.ContactModel

class ContactDao {

    fun fetchData(): MutableList<ContactModel> {
        return LocalDatabase.contactList
    }
}