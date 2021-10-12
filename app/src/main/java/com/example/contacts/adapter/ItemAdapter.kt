package com.example.contacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.ContactModel


class ItemAdapter(
    private val contactList: MutableList<ContactModel>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView2:TextView = itemView.findViewById(R.id.textView2)
        val imageView: ImageView =itemView.findViewById(R.id.imageView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = contactList[position]
        holder.textView.text =data.name
        holder.textView2.text=data.phoneNo
        holder.imageView.setImageResource(data.imageId)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
