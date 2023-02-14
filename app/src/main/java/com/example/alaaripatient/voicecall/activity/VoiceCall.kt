package com.example.alaaripatient.voicecall.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alaaripatient.R
import com.example.alaaripatient.callback.`interface`.CallBackAdapter
import com.example.alaaripatient.databinding.ActivityVoiceCallBinding
import com.example.alaaripatient.home.fragement.recylerwebinar.RecylerWebinarAdapter
import com.example.alaaripatient.home.fragement.recylerwebinar.RecylerWebinarModal

class VoiceCall : AppCompatActivity() {
    val recylerWebinarAdapter: RecylerWebinarAdapter by lazy {
        RecylerWebinarAdapter(recylerWebinarModal)
    }
    private val recylerWebinarModal:ArrayList<RecylerWebinarModal> by lazy {
        ArrayList()
    }
    lateinit var binding: ActivityVoiceCallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVoiceCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recylerWebinar()
        goBackBtn()
    }

    private fun goBackBtn() {
        binding.backBtn.setOnClickListener {
           onBackPressed()
        }
    }

    private fun recylerWebinar() {
        binding.voicallrecyler.adapter=recylerWebinarAdapter
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar1","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar2","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar3","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarAdapter.callBack(object : CallBackAdapter {
            override fun callback(position: Int, modal: RecylerWebinarModal) {

            }
        })
    }
}