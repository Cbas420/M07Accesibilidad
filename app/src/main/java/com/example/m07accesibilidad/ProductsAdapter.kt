package com.example.m07accesibilidad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(
    private val context: Context, private val productList: List<Product>
                    ) : BaseAdapter() {

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

        return view
    }

    private class ViewHolder(view: View) {
        val productImageView: ImageView = view.findViewById(R.id.productImageView)
        val productNameTextView: TextView = view.findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = view.findViewById(R.id.productPriceTextView)
    }
}