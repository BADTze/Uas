package com.imam.myuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.imam.myuas.databinding.ActivityLoginBinding
import com.imam.myuas.API.ApiClient
import com.imam.myuas.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
        private var binding : ActivityLoginBinding? = null
        private var username :String = ""
        private var password :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        btnLogin.setOnClickListener{
            val username = binding!!.etUsername.text.toString()
            val password = binding!!.etPassword.text.toString()

            if (username.isEmpty() and password.isEmpty()) {
                etUsername.error = "User required"
                etUsername.requestFocus()
                etPassword.error = "Password required"
                etPassword.requestFocus()
            }else{
                val api= ApiClient().getInstance()
                api.userLogin(username, password).enqueue(object:Callback<LoginResponse>{
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.body()?.response==true){

                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this@LoginActivity,"Login Gagal",Toast.LENGTH_LONG).show()
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e("Pesan error", "\$(t.message)")
                    }
                })
            }
        }

    }

}




