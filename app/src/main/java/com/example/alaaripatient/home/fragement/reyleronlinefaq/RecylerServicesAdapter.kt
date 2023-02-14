package com.example.alaaripatient.home.fragement.reyleronlinefaq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alaaripatient.databinding.RecyleronlinefaqBinding

class RecylerServicesAdapter(
     var modallist:ArrayList<ServiceData>
    ) :
    RecyclerView.Adapter<RecylerServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =RecyleronlinefaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        Glide.with(holder.itemView.context).load(modal.imageUrl).into(holder.itemBinding.imageview)
        holder.itemBinding.text.text=modal.serviceType
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:RecyleronlinefaqBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}