package com.example.alaaripatient.homerecylerclick.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alaaripatient.R
import com.example.alaaripatient.booking.fragment.durationresponse.DurationModal
import com.example.alaaripatient.databinding.BookingrecylerBinding
import com.example.alaaripatient.databinding.CounsellingalltopicsrecylerBinding
import com.example.alaaripatient.databinding.CounsellingtopicsrecylerBinding
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingModal
import com.example.alaaripatient.home.fragement.retrofitmvvm.CousellingResponse

class CousellingTopicsAdapter(
     var modallist:ArrayList<CounsellingModal>
    ) :
    RecyclerView.Adapter<CousellingTopicsAdapter.ViewHolder>() {
    lateinit var itemClick:Interface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =CounsellingalltopicsrecylerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    interface Interface{
        fun itemClickIntFun(position: Int,modal: CounsellingModal)
    }
    fun recylerFun(click:Interface){
        itemClick=click
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.name.text=modal.topicName
        Glide.with(holder.itemView.context).load(modal.imageUrl).into(holder.itemBinding.familyProfImage)
        holder.itemView.setOnClickListener {
            itemClick.itemClickIntFun(position,modal)
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:CounsellingalltopicsrecylerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}