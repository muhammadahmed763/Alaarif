package com.example.alaaripatient.booking.fragment.bookingrecyler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaaripatient.R
import com.example.alaaripatient.booking.fragment.durationresponse.DurationModal
import com.example.alaaripatient.databinding.BookingrecylerBinding

class BookingRecAdapter(
     var modallist:ArrayList<DurationModal>
    ) :
    RecyclerView.Adapter<BookingRecAdapter.ViewHolder>() {
    lateinit var click: BookingRecClick
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =BookingrecylerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }
    interface BookingRecClick {
        fun clickFunction(position:Int,modal: DurationModal)
    }
    fun recylerClick(listener: BookingRecClick){
        click=listener
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var modal=modallist[position]
        holder.itemBinding.minutesTimeText.text=modal.duration
        holder.itemBinding.dollarText.text= modal.consultantPrice.toString()
        holder.itemBinding.calenderText.text=modal.durationType
        holder.itemBinding.hourText.text=modal.duration
        holder.itemBinding.voiceCallBtn.text=modal.serviceType
        holder.itemView.setOnClickListener {
            click.clickFunction(position,modal)
        }
    }
    override fun getItemCount(): Int {
        return modallist.size
    }
    class ViewHolder(var itemBinding:BookingrecylerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}