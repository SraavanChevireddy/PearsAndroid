package com.sraavanchevireddy.pears

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoriesAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {
    var onItemClick: ((String) -> Unit)? = null
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.tv_category)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
        holder.itemTextView.setOnClickListener { onItemClick?.invoke(itemsList.get(position)) }
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}