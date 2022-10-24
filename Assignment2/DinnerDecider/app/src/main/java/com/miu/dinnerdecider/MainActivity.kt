package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    val list = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese", "MO:MO")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(list.count())
            textView.text = list[randomFood]
        }

        addFoodBtn.setOnClickListener {
            val newFood = edit_text.text.toString()
            list.add(newFood)
            edit_text.text.clear()
           // println(list)
        }

    }
}