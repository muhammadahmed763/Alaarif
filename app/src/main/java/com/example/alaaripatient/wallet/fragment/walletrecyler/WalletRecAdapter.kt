package com.example.alaaripatient.wallet.fragment.walletrecyler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.booking.fragment.bookingrecyler.BookingRecAdapter
import com.example.alaaripatient.callback.`interface`.CallBackAdapter
import com.example.alaaripatient.databinding.RecylerwebinarBinding
import com.example.alaaripatient.databinding.TopuprecBinding
import com.example.alaaripatient.databinding.TransferrecBinding
import com.example.alaaripatient.home.fragement.recylerwebinar.RecylerWebinarAdapter

class WalletRecAdapter(val modallist:ArrayList<WalletRecModal>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var TOPUPTYPE=1;
    var TRANSFERTYPE=2;
    lateinit var callBackAdapter: CallBackAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder {
        if (viewType==1){
            val v =TopuprecBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TopUp(v)
        }else{
            val v =TransferrecBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return Transfer(v)
        }
    }
    fun callBack(lisne:CallBackAdapter){
       callBackAdapter=lisne
    }
    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position: Int) {
        if (holder.javaClass== TopUp::class.java){
            val viewHolder=holder as TopUp
            val modal=modallist[position]
            holder.topupbinding.dateTopup.text=modal.date
            holder.topupbinding.amountTopUp.text=modal.amount
            holder.topupbinding.amounttype.text=modal.amounttype
        }else{
            val modal=modallist[position]
            val viewHolder=holder as Transfer
            holder.transferbinding.dateTopup.text=modal.date
            holder.transferbinding.amounttype.text=modal.amounttype
            holder.transferbinding.amountTopUp.text=modal.amount
        }
    }

    override fun getItemViewType(position: Int): Int {
        val modal=modallist[position]
        if (modal.userType=="1"){
            return TOPUPTYPE
        }else{

            return TRANSFERTYPE
        }
    }
    override fun getItemCount(): Int {
       return  modallist.size
    }
    class TopUp(var topupbinding:TopuprecBinding) :
        RecyclerView.ViewHolder(topupbinding.root) {
    }
    class Transfer(var transferbinding:TransferrecBinding) :
        RecyclerView.ViewHolder(transferbinding.root) {
    }
}