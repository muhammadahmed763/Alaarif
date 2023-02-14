package com.example.alaaripatient.home.fragement.retrofitmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alaaripatient.databinding.RecyleronlinecounslingBinding

class RecylerCounsellingAdapter(
     var modallist:ArrayList<CounsellingModal>
    ) :
    RecyclerView.Adapter<RecylerCounsellingAdapter.ViewHolder>() {
    lateinit var click:HomeRecClick
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =RecyleronlinecounslingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    interface HomeRecClick {
       fun recClick(position: Int,modal: CounsellingModal)
    }

    fun clickFun(clickFun:HomeRecClick){
        click=clickFun
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]

        Glide.with(holder.itemView.context).load(modal.imageUrl).into(holder.itemBinding.imageview)
        holder.itemBinding.text.text=modal.topicName
        holder.itemView.setOnClickListener {
            click.recClick(position,modal)
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:RecyleronlinecounslingBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}