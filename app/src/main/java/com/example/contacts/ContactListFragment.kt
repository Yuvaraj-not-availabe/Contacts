package com.example.contacts

import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.adapter.ItemAdapter
import com.example.contacts.model.ContactModel
import com.example.contacts.viewModel.ContactListViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

class ContactListFragment : Fragment() {
    private val contactListViewModel = ContactListViewModel()
    private var contactList = mutableListOf<ContactModel>()
    private lateinit var fragmentView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        runBlocking {
            fragmentView = inflater.inflate(R.layout.fragment_contact_list, container, false)
            val recyclerView = fragmentView.findViewById<RecyclerView>(R.id.recycler_view)
            val contactFlow = contactListViewModel.getContactListViewModel()
            contactFlow.collect {
                contactList.addAll(it)

            }
            recyclerView.adapter = ItemAdapter(contactList)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
            fragmentView.findViewById<ImageView>(R.id.all).setOnClickListener {
                recyclerView.adapter = ItemAdapter(contactList)
                //it.setBackgroundColor(0xFF1976D2)
            }
            fragmentView.findViewById<ImageView>(R.id.favourite).setOnClickListener {
                recyclerView.adapter = ItemAdapter(
                    contactList.filter { it.favourite } as MutableList<ContactModel>)
            }

        }
        return fragmentView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.contact_menu, menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}