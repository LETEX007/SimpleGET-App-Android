package com.example.retrofitapi2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProdAdapter(private var listaprod: List<Producto>):RecyclerView.Adapter<ProdAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val id :TextView = itemView.findViewById(R.id.id)
        val nombre :TextView = itemView.findViewById(R.id.nombre)
        val imgView :ImageView = itemView.findViewById(R.id.imgView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdAdapter.ViewHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.productos, parent, false))
    }



    override fun onBindViewHolder(holder: ProdAdapter.ViewHolder, position: Int) {
        val prod = listaprod[position]
        holder.id.text = prod.idpro.toString()
        holder.nombre.text = prod.nombre.toString()
        val imgurl = "https://technoworld.overlife.club/"+ prod.img.toString()
        Picasso.get().load(imgurl).into(holder.imgView)

    }

    override fun getItemCount(): Int {
        return listaprod.size
    }
}