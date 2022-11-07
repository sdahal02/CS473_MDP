package com.miu.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.miu.walmart.data.User
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val user: User? = intent.getSerializableExtra("user") as User?
       loggedInUser.text = " Welcome: ${user?.emailID}"

    }

    fun imgClick(view: View){
        var category = ""
        when(view.id){
            R.id.electronicsImg -> category = "Electronics"
            R.id.clothingsImg -> category = "Clothings"
            R.id.cosmeticsImg -> category = "Cosmetics"
            R.id.groceryImg -> category = "Groceries"
        }
        Toast.makeText(this,"You have chosen the $category category of shopping",Toast.LENGTH_LONG).show()
    }
}