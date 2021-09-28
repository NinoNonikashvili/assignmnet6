package com.example.resulttomainactivity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var firstName:String,
    var lastname:String,
    var email:String,
    var birth:String,
    var gender:String
        ):Parcelable