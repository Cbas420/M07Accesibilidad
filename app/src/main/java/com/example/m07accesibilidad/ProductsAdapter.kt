package com.example.m07accesibilidad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductsAdapter(
    private val context: Context,
    private val productList: List<Product>,
    private val itemClickListener: StoreFragment
                     ) : BaseAdapter() {

    private val doubleClickThreshold: Long = 300 // Tiempo máximo entre clicks para considerarlos "dobles clicks"
    private var lastClickTime: Long = 0 // Para almacenar el último click

    override fun getCount(): Int {
        return productList.size
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.store_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val product = productList[position]
        viewHolder.productImageView.setImageResource(product.imageResId)
        viewHolder.productNameTextView.text = product.name
        viewHolder.productPriceTextView.text = product.price

        // Manejo de click
        view.setOnClickListener {
            val currentClickTime = System.currentTimeMillis()
            if (currentClickTime - lastClickTime < doubleClickThreshold) {
                // Detectamos un doble click
                itemClickListener.onItemDoubleClick(position)
            } else {
                // Es un click normal
                itemClickListener.onItemClick(position)
            }
            lastClickTime = currentClickTime
        }

        // Manejo de long click
        view.setOnLongClickListener {
            itemClickListener.onItemLongClick(position)
            true // Retornamos true para indicar que el long click fue consumido
        }

        return view
    }

    private class ViewHolder(view: View) {
        val productImageView: ImageView = view.findViewById(R.id.productImageView)
        val productNameTextView: TextView = view.findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = view.findViewById(R.id.productPriceTextView)
    }

    // Interfaz para los eventos de click
    interface ItemClickListener {
        fun onItemClick(position: Int)
        fun onItemDoubleClick(position: Int)
        fun onItemLongClick(position: Int)
    }
}
