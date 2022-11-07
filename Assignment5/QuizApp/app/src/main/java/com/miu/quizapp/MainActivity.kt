package com.miu.quizapp

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            val current = LocalDateTime.now()

            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("“Congratulations! Your score for the quiz submitted on $current  is 50%")

                .setCancelable(false)

                .setPositiveButton("Ok", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })


            val alert = dialogBuilder.create()
            alert.setTitle("Result")
            alert.show()
        }
    }


}