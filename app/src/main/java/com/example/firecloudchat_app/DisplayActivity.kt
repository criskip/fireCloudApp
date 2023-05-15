package com.example.firecloudchat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firecloudchat_app.databinding.ActivityDisplayBinding

class DisplayActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDisplayBinding
    private lateinit var userArrayList : ArrayList<User>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageid = intArrayOf(

            R.drawable.man,R.drawable.doctor,R.drawable.braids,
            R.drawable.mechanic,R.drawable.barbers,R.drawable.hill,R.drawable.lawyer

        )

        val name = arrayOf(
            "Chris Kemboi",
            "Selina Wavua",
            "Jay Mwinyi",
            "Rodgers Mwafungo",
            "Rachel Mugure",
            "Kennedy Njoroge",
            "Elizabeth Cherono"
        )

        val message = arrayOf(

            "Android developer",
            "Clinical officer",
            "Salonist",
            "Mechanic",
            "Barber",
            "Quantity surveyor",
            "Lawyer"

        )

        val number = arrayOf(

            "0724907784",
            "0768219950",
            "0745678345",
            "0786543456",
            "0726719924",
            "0723946599",
            "0786940934"

        )

        val town = arrayOf(

            "Imara daima, Nairobi",
            "Makupa, Mombasa",
            "High level, Mombasa",
            "Oyugis, Homabay",
            "Mai mahiu, Nakuru",
            "Eldoret, Uasin gishu",
            "Westlands, Nairobi"


        )

        userArrayList = ArrayList()
         for ( i in name.indices){

             val user = User(name[i],message[i], number[i],town[i],imageid[i])
             userArrayList.add(user)

         }

        binding.ListV.isClickable = true
        binding.ListV.adapter = MyAdapter(this,userArrayList)
        binding.ListV.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = number[position]
            val town = town[position]
            val imageid = imageid[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("town",town)
            i.putExtra("imageid",imageid)
            startActivity(i)


        }

    }
}


