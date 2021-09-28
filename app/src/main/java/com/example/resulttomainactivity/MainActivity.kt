package com.example.resulttomainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.resulttomainactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { send() }
    }
    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if(it.resultCode== RESULT_OK){
                if(intent!=null) {
                    var user1:User = intent.getParcelableExtra<User>("USER1")as User
                    binding.firstName.text = user1!!.firstName
                    binding.lastName.text = user1.lastname
                    binding.email.text = user1.email
                    binding.gender.text = user1.gender
                    binding.birth.text = user1.birth
                }


        }

    }


    fun send(){
        val intent: Intent = Intent(this, UpdateUserData::class.java)

        resultContract.launch(intent)

    }
}