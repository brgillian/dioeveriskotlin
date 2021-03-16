package com.gillian.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        return ContactAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder:ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list:List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return list.size
    }
    class ContactAdapterViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvTelefone: TextView = itemView.findViewById(R.id.tv_telefone)
        private val ivFoto:ImageView = itemView.findViewById(R.id.iv_foto)

        fun bind(contact:Contact){
            tvName.text = contact.nome
            tvTelefone.text = contact.telefone

        }
    }
}