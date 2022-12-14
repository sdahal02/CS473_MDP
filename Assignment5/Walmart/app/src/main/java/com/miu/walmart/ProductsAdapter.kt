package com.miu.walmart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.walmart.data.Product


class ProductsAdapter(private val onClick: OnItemClickListener) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private var products: List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.product_card.setOnClickListener {
                onClick.onItemClick(product)
            }
            itemView.product_name.text = product.title
            itemView.product_color.text = "Color: ${product.color}"
            itemView.product_price.text = "Price: $${product.price}"
            itemView.product_image.setImageResource(product.image)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }
}