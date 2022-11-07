package com.miu.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.walmart.R.*
import com.miu.walmart.data.Product

class ElectronicsActivity : AppCompatActivity() {

    private val productList = mutableListOf(
        Product("HP Spectre 360", 1500.00, "Black", "@drawable/hp_laptop_png_hd", "0978", "HP Laptop DESC" ),
        Product("Google Pixel 7 Pro", 800.00, "White", "@drawable/pixel", "0979", "Google Pixel DESC DESC" ),
        Product("Pixel Watch Active Band", 49.99, "Black", "@drawable/pixelwatch", "0980", "Pixel Watch DESC" ),
        Product("Pixel Earbuds", 149.99, "Orange", "@drawable/earbuds", "0981", "Pixel earbuds DESC" )

    )
    var ProductsAdapter = ProductsAdapter(Product)
    itemsView.adapter = ProductsAdapter
    itemsView.LayoutManager = ConstraintLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_electronics)
    }
}