package com.example.alaaripatient.meetouradvisers.recyler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.databinding.AdvisorrecylerBinding
import com.example.alaaripatient.databinding.RecyleronlinecounslingBinding

class AdvisorRecAdapter(
     var modallist:ArrayList<AdvisorRecModal>
    ) :
    RecyclerView.Adapter<AdvisorRecAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =AdvisorrecylerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.familyProfImage.setImageResource(R.drawable.ic_launcher_background)
        holder.itemBinding.experience.text=modal.experience
        holder.itemBinding.courses.text=modal.courses
        holder.itemBinding.reviews.text=modal.reviews
        holder.itemBinding.served.text=modal.served
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:AdvisorrecylerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}