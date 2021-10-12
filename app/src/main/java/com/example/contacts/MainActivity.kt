package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.adapter.ItemAdapter
import com.example.contacts.model.ContactModel
import com.example.contacts.viewModel.ContactListViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val contactListViewModel=ContactListViewModel()
    private var contactList= mutableListOf<ContactModel>()
    override fun onCreate(savedInstanceState: Bundle?): Unit = runBlocking{
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ContactListFragment())
                .commit()
        }
    }
}