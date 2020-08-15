package com.example.hello
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.Callback

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Register.setOnClickListner{
            val  intent = Intent(baseContext,MainActivity::class.java)
            startActivity(intent)

        }


            var firstName = textView2.text.toString()
            var lastName =  textView3.text.toString()
            var email = textView4.text.toString()
            var password = editTextTextPassword.text
            var phoneNumber = editTextTextPassword.text
            var passwordConfirm = textView5.text.toString()
            var forgotPassword = textForgotPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name "first_name",firstName)
                .addFormDataPart(name "last_name",lastName)
                .addFormDataPart(name "email",email)
                .addFormDataPart(name "phone_number",phoneNumeber.toString())
                .addFormDataPart(name"password",password.toString())
                .bulid()

            registerUser(requestBody)
            makeText(baseContext,lastName,LENGTH_SHORT).show()


        }
    }

     fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}
