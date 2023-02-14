package com.example.alaaripatient.wallet.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alaaripatient.databinding.FragmentWalletBinding
import com.example.alaaripatient.transerfer.activity.TopUp
import com.example.alaaripatient.wallet.fragment.walletrecyler.WalletRecAdapter
import com.example.alaaripatient.wallet.fragment.walletrecyler.WalletRecModal

class Wallet : Fragment() {
    val walletRecAdapter: WalletRecAdapter by lazy {
        WalletRecAdapter(walletRecModal)
    }
    val walletRecModal:ArrayList<WalletRecModal> by lazy {
        ArrayList()
    }
    lateinit var binding: FragmentWalletBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentWalletBinding.inflate(inflater, container, false)
        val v=binding.root
        walletRecyler()
        return v
    }

    private fun walletRecyler() {
        binding.transfer.setOnClickListener {
            startActivity(Intent(requireContext(), TopUp::class.java))
        }
        binding.walletRecylerView.adapter=walletRecAdapter
        walletRecModal.add(WalletRecModal("Transfer","20-10-2022","2000KWD","1"))
        walletRecModal.add(WalletRecModal("Transfer","20-10-2022","2000KWD","1"))
        walletRecModal.add(WalletRecModal("Transfer","20-10-2022","2000KWD","1"))
        walletRecModal.add(WalletRecModal("G","20-10-2022","2000KWD","2"))
        walletRecModal.add(WalletRecModal("G","20-10-2022","2000KWD","2"))
        walletRecModal.add(WalletRecModal("G","20-10-2022","2000KWD","2"))
    }

}