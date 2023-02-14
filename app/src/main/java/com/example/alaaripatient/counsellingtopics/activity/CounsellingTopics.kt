package com.example.alaaripatient.counsellingtopics.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alaaripatient.databinding.ActivityCounsellingTopicsBinding
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingFactory
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingModal
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingViewModal
import com.example.alaaripatient.homerecylerclick.adapter.CousellingTopicsAdapter

class CounsellingTopics : AppCompatActivity() {
    lateinit var binding: ActivityCounsellingTopicsBinding
    lateinit var counsellingViewModal: CounsellingViewModal
    private val recylerCounsellingAdapter:CousellingTopicsAdapter by lazy { CousellingTopicsAdapter(cousellingModal) }
    private val cousellingModal:ArrayList<CounsellingModal> by lazy { ArrayList() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCounsellingTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counsellingViewModal= ViewModelProvider(this, CounsellingFactory(this)
        ).get(CounsellingViewModal::class.java)
        counsellingViewModal.liveData.observe(this, Observer{
            cousellingModal.addAll(it.data)
            recylerCounsellingAdapter.notifyDataSetChanged()
        })
        binding.recylerView.adapter=recylerCounsellingAdapter
    }
}