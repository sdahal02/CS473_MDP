package com.miu.walmart.data

import java.io.Serializable

 /*data class Product(var title: String, var price: Double, var color: String, var image: String, var itemId: String, var desc: String){

 }*/

data class Product(
 val title: String,
 val price: String,
 val color: String,
 val image: Int,
 val itemId: Long,
 val desc: String,
) : Serializable

