package com.example.alaaripatient.homerecylerclick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.alaaripatient.counsellingtopics.activity.CounsellingTopics
import com.example.alaaripatient.databinding.ActivityHomeRecClickBinding
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingFactory
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingModal
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingViewModal
import com.example.alaaripatient.homerecylerclick.adapter.CousellingTopicsAdapter

class HomeRecClick : AppCompatActivity() {
    val adapter:CousellingTopicsAdapter by lazy { CousellingTopicsAdapter(modal) }
    val modal:ArrayList<CounsellingModal> by lazy { ArrayList() }
    lateinit var viewModal:CounsellingViewModal
    lateinit var binding: ActivityHomeRecClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeRecClickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModal=ViewModelProvider(this,CounsellingFactory(this)).get(CounsellingViewModal::class.java)
        viewModal.liveData.observe(this){
            modal.addAll(it.data)
            adapter.notifyDataSetChanged()
        }
        binding.recylerView.adapter=adapter
        adapter.recylerFun(object :CousellingTopicsAdapter.Interface{
            override fun itemClickIntFun(position: Int, modal: CounsellingModal) {
                startActivity(Intent(this@HomeRecClick, CounsellingTopics::class.java))
            }

        })

        adapter.notifyDataSetChanged()
        val intentModal = intent.getSerializableExtra("Modal") as? CounsellingModal
        Glide.with(this).load(intentModal!!.imageUrl).into(binding.imageIntent)
    }
}