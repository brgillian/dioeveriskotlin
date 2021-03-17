package com.gillian.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gillian.lista.R.layout.contact_item

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    // Criação da view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(contact_item,parent,false)
        return ContactAdapterViewHolder(view)
    }

    // Populando a view
    override fun onBindViewHolder(holder:ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // Pegando o tamanho da lista
    override fun getItemCount(): Int {
       return list.size
    }

    // Passa a lista externa para dentro do Adapter
    fun updateList(list:List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvTelefone: TextView = itemView.findViewById(R.id.tv_telefone)
        private val ivFoto: ImageView = itemView.findViewById(R.id.iv_foto)

        fun bind(contact:Contact){
            tvName.text = contact.nome
            tvTelefone.text = contact.telefone

        }
    }
}