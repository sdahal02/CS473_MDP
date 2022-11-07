package com.miu.walmart

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.walmart.data.User

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var usersList = mutableListOf(
        User("sdahal", "sd", "sdahal@gmail.com", "sdahal"),
        User("Victor", "Payan", "victorp@ermian.com", "victorp"),
        User("Cynthia", "Kelle", "cynthiak@gmail.com", "cynthiak"),
        User("David", "Ryan", "davidp@gmail.com", "davidp"),
        User("Shyan", "Jentz", "shyanj@gmail.com", "shyanj")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInBtn.setOnClickListener {
            var emailID = emailInput.text.toString()
            var password = passwordInput.text.toString()


            for (user in usersList)
                if (user.emailID == emailID && user.password == password) {
                    val intent = Intent(this, ShoppingActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                }
        }
    }



}