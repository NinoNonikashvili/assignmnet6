package com.example.resulttomainactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resulttomainactivity.databinding.ActivityUpdateUserDataBinding


class UpdateUserData : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateUserDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { save() }
    }
    fun save(){
        var updatedUser = User(binding.firstName.text.toString(),
            binding.lastName.text.toString(),
            binding.email.text.toString(),
            binding.birth.text.toString(),
            binding.gender.text.toString()
        )

        var returnedData:Intent =Intent()
        returnedData.putExtra("updatedUser", updatedUser)
        setResult(Activity.RESULT_OK, returnedData )
        finish()

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}