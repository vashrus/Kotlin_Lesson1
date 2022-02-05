package com.example.myapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.feel

class FirstAdapter(val context:Context, val list: List<feel>): RecyclerView.Adapter<FirstAdapter.MyVH>() {
    class MyVH(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.image_feel)
        val textView:TextView = itemView.findViewById(R.id.Text_feel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.first_adapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.imageView.setImageDrawable(context.getDrawable(list[position].Image))
        holder.textView.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }

}