package com.example.alaaripatient.family.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alaaripatient.R
import com.example.alaaripatient.activity.AllCustomer
import com.example.alaaripatient.databinding.FragmentFamilyBinding
import com.example.alaaripatient.family.fragment.familyrecyler.FamilyRecAdapter
import com.example.alaaripatient.family.fragment.familyrecyler.FamilyRecModal

class Family : Fragment() {
    val familyRecAdapter: FamilyRecAdapter by lazy {
        FamilyRecAdapter(familyRecModal)
    }
    private val familyRecModal:ArrayList<FamilyRecModal> by lazy {
        ArrayList()
    }
    lateinit var binding: FragmentFamilyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFamilyBinding.inflate(inflater,container,false)
        val v=binding.root
        familyRecyler()
        return v
    }
    private fun familyRecyler() {
        binding.addMember.setOnClickListener {
            startActivity(Intent(requireContext(),AllCustomer::class.java))
        }
        binding.familyRecView.adapter=familyRecAdapter
        familyRecModal.add(
            FamilyRecModal(R.drawable.ic_launcher_background,"Dr.M.Ahmed","619",
                "Father")
        )
        familyRecModal.add(
            FamilyRecModal(R.drawable.ic_launcher_background,"Dr.M.Ahmed","619",
                "Father")
        )
        familyRecModal.add(
            FamilyRecModal(R.drawable.ic_launcher_background,"Dr.M.Ahmed","619",
                "Father")
        )
    }

}