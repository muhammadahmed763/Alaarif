package com.example.alaaripatient.booking.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.alaaripatient.booking.fragment.bookingrecyler.BookingRecAdapter
import com.example.alaaripatient.booking.fragment.durationresponse.DurationModal
import com.example.alaaripatient.booking.fragment.mvvm.BookingFactory
import com.example.alaaripatient.booking.fragment.mvvm.BookingViewModal
import com.example.alaaripatient.databinding.FragmentBookingBinding
import com.example.alaaripatient.retrofit.baseresponse.BaseResponse
import com.example.alaaripatient.voicecall.activity.VoiceCall

class Booking : Fragment() {

    private val bookingRecAdapter: BookingRecAdapter by lazy { BookingRecAdapter(bookingRecModal) }
    private val bookingRecModal:ArrayList<DurationModal> by lazy { ArrayList() }
    lateinit var viewModal: BookingViewModal
    lateinit var binding:FragmentBookingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBookingBinding.inflate(inflater,container,false)
        val v=binding.root

        viewModal=ViewModelProvider(requireActivity(),BookingFactory(requireContext())).get(BookingViewModal::class.java)

        viewModal.liveData.observe(requireActivity()){
            when(it){
                is BaseResponse.Success->{
                    bookingRecModal.addAll(it.data!!.data)
                    bookingRecAdapter.notifyDataSetChanged()
                    Toast.makeText(requireContext(), "Ok", Toast.LENGTH_SHORT).show()
                }
                is BaseResponse.Error->{

                }
                is BaseResponse.Loading->{
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        }

        recylerBooking()
        return v
    }

    private fun recylerBooking() {
        bookingRecAdapter.notifyDataSetChanged()
        binding.bookingRecylerView.adapter=bookingRecAdapter
        bookingRecAdapter.recylerClick(object : BookingRecAdapter.BookingRecClick{
            override fun clickFunction(position: Int, modal: DurationModal) {
                startActivity(Intent(requireContext(),VoiceCall::class.java))
            }

        })

    }



}