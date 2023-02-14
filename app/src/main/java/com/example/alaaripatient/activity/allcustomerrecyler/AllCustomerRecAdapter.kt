package com.example.alaaripatient.activity.allcustomerrecyler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.databinding.AllcustomerrecylerBinding

class AllCustomerRecAdapter(
     var modallist:ArrayList<CustomerData>
    ) :
    RecyclerView.Adapter<AllCustomerRecAdapter.ViewHolder>() {
    lateinit var callBackAdapter: CallBack
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =AllcustomerrecylerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    fun callBack(lisne: CallBack){
       callBackAdapter=lisne
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.familyProfImage.setImageResource(R.drawable.ic_launcher_background)
        holder.itemBinding.name.text=modal.title
        holder.itemView.setOnClickListener {
            callBackAdapter.callback(position,modal)
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:AllcustomerrecylerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}