package com.example.alaaripatient.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.alaaripatient.activity.allcustomerrecyler.AllCustomerRecAdapter
import com.example.alaaripatient.activity.allcustomerrecyler.AllCustomerViewModal
import com.example.alaaripatient.activity.allcustomerrecyler.CustomerData
import com.example.alaaripatient.databinding.ActivityAllCustomerBinding

class AllCustomer : AppCompatActivity() {
    lateinit var viewModel: AllCustomerViewModal
    lateinit var binding: ActivityAllCustomerBinding
    val customerRecAdapter: AllCustomerRecAdapter by lazy {
        AllCustomerRecAdapter(modal)
    }
    val modal:ArrayList<CustomerData> by lazy {
        ArrayList()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelCustomer()
        recylerView()
        viewModel=ViewModelProvider(this).get(AllCustomerViewModal::class.java)
        viewModel.liveData.observe(this){
            it.data

//            when(it){
//                is BaseResponse.Success->{
//                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//                    modal.addAll(it.data!!.data)
//                    customerRecAdapter.notifyDataSetChanged()
//                }
//                is BaseResponse.Loading->{
//                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
//                }
//                is BaseResponse.Error->{
//                    Toast.makeText(this, "Crashed", Toast.LENGTH_SHORT).show()
//                }
//            }
        }
    }

    private fun recylerView() {
        binding.allCustomerRecylerView.adapter=customerRecAdapter
        customerRecAdapter.notifyDataSetChanged()
    }

    private fun viewModelCustomer() {

    }
}