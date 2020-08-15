package com.example.hello
import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
 @SerializedName(values: "message")var  Message: String,
 @SerializeName(values: "student")var Student: Student,

)
