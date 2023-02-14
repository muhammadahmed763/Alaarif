package com.example.alaaripatient.home.fragement.recylerwebinar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.callback.`interface`.CallBackAdapter
import com.example.alaaripatient.databinding.RecyleronlinefaqBinding
import com.example.alaaripatient.databinding.RecylerwebinarBinding

class RecylerWebinarAdapter(
     var modallist:ArrayList<RecylerWebinarModal>
    ) :
    RecyclerView.Adapter<RecylerWebinarAdapter.ViewHolder>() {
    lateinit var callBackAdapter: CallBackAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =RecylerwebinarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    fun callBack(lisne:CallBackAdapter){
       callBackAdapter=lisne
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.imageview.setImageResource(R.drawable.ic_launcher_background)
        holder.itemBinding.text.text=modal.text
        holder.itemBinding.date.text=modal.date
        holder.itemView.setOnClickListener {
            callBackAdapter.callback(position,modal)
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:RecylerwebinarBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}