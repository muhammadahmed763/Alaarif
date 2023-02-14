package com.example.alaaripatient.family.fragment.familyrecyler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.callback.`interface`.CallBackAdapter
import com.example.alaaripatient.databinding.FamilyrecylerBinding
import com.example.alaaripatient.databinding.RecylerwebinarBinding

class FamilyRecAdapter(
     var modallist:ArrayList<FamilyRecModal>
    ) :
    RecyclerView.Adapter<FamilyRecAdapter.ViewHolder>() {
    lateinit var callBackAdapter: CallBackAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =FamilyrecylerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    fun callBack(lisne:CallBackAdapter){
       callBackAdapter=lisne
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.familyProfImage.setImageResource(R.drawable.ic_launcher_background)
        holder.itemBinding.name.text=modal.name
        holder.itemBinding.familyCode.text=modal.familyCode
        holder.itemBinding.relationType.text=modal.relationType
        holder.itemView.setOnClickListener {
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:FamilyrecylerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}