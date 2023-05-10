package com.example.firecloudchat_app

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter ( private val context : Activity,private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context,
    R.layout.list_item,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item, null)

        val imageView : ImageView = view.findViewById(R.id.profile_pic)
        val username : TextView = view.findViewById(R.id.name_View)
        val message : TextView = view.findViewById(R.id.message_View)

        imageView.setImageResource(arrayList[position].image)
        username.text = arrayList[position].name
        message.text = arrayList[position].message




        return view
    }

}