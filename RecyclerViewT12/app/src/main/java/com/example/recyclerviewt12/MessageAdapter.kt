package com.example.recyclerviewt12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(
    private val messages: MutableList<Message>,
    private val callback:(Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.VH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_message,parent, false)

        val vh = VH(v)

        vh.itemView.setOnClickListener {
            val message = messages[vh.adapterPosition]
            callback(message)
        }

        vh.itemView.setOnLongClickListener {
            val message = messages[vh.adapterPosition]
            callback(message)
            messages.removeAt(vh.adapterPosition)
            true
        }
        return vh
    }

    override fun getItemCount(): Int  = messages.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val (title, text) = messages[position]
        holder.txtTitle.text = title
    }


    class  VH(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle: TextView = itemView.txtTitle
    }
}