package com.example.alaaripatient.transerfer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alaaripatient.databinding.ActivityTransferWallelBinding

class TopUp : AppCompatActivity() {
    lateinit var binding: ActivityTransferWallelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTransferWallelBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}