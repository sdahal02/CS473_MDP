package com.miu.walmart

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(
    itemView!!
) {
    var currentPosition = 0
    open fun onBind(position: Int) {
        currentPosition = position
    }
}