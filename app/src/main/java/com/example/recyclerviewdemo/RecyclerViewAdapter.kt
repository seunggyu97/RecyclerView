package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class RecyclerViewAdapter(val fruitList: List<Fruit>, private val clickListener: (Fruit) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

}

class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener{
            clickListener(fruit)
        }
    }
}