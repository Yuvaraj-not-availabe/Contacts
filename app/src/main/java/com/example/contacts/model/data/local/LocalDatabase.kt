package com.example.contacts.model.data.local

import com.example.contacts.R
import com.example.contacts.model.ContactModel

object LocalDatabase {
    var contactList = mutableListOf<ContactModel>(
        ContactModel(23, "Yuvi", "1740164", true, R.drawable.image1),
        ContactModel(37, "Angela", "012641849", true,R.drawable.image2),
        ContactModel(20, "Yoki", "0124186496", false,R.drawable.image3),
        ContactModel(24, "Ice", "1740164", true,R.drawable.image4),
        ContactModel(36, "Brad", "937502641849", true,R.drawable.image5),
        ContactModel(21, "Aang", "6433686496", false,R.drawable.image6),
        ContactModel(34, "Valkyre", "36361740164", true,R.drawable.image7),
        ContactModel(49, "Naruto", "9650012641849", true,R.drawable.image8),
        ContactModel(50, "Mr.Robot", "4356186496", false,R.drawable.image9),
        ContactModel(31, "Thor", "36361740164", true,R.drawable.image10),
        ContactModel(43, "Mr.White", "500121849", true,R.drawable.image11),
        ContactModel(55, "Bojack", "6186496234", false,R.drawable.image12_),
    )
}
