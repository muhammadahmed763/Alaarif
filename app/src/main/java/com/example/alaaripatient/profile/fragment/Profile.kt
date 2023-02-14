package com.example.alaaripatient.profile.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.alaaripatient.databinding.FragmentProfileBinding
import com.example.alaaripatient.editprofile.EditProfile
import com.example.alaaripatient.profile.fragment.profilemvvm.ProfileFactory
import com.example.alaaripatient.profile.fragment.profilemvvm.ProfileViewModal
import com.example.alaaripatient.loginacitivity.mvvm.BaseResponse

class Profile : Fragment() {
    lateinit var binding:FragmentProfileBinding
    lateinit var viewModal: ProfileViewModal
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(inflater, container, false)
        val v=binding.root

        editProfile()

        return v
    }
    private fun viewModal(){
        viewModal=ViewModelProvider(requireActivity(), ProfileFactory(requireContext())).get(
            ProfileViewModal::class.java)
        viewModal.liveData.observe(requireActivity()) {
            when(it){
                is BaseResponse.Success->{
                    binding.firstNameEd.text=it.data!!.data.get(0).firstName
                    binding.firstNameEd.text=it.data.data.get(0).firstName
                    binding.lastNameEd.text=it.data.data.get(0).lastName
                    binding.mobileEd.text=it.data.data.get(0).mobileNumber
                    binding.emailEd.text=it.data.data.get(0).email
                    binding.genderProf.text=it.data.data.get(0).gender
                    binding.genderB.text=it.data.data.get(0).gender
                    binding.dateofBorn.text= it.data.data.get(0).createdOn.toString()
                    binding.streetEd.text=it.data.data.get(0).street
                    binding.areaEd.text=it.data.data.get(0).area
                    binding.cityText.text=it.data.data.get(0).city
                    binding.countryText.text=it.data.data.get(0).country
                    binding.languageText.text=it.data.data.get(0).selectLanguage
                    Glide.with(requireContext()).load(it.data.data.get(0).facebookUrl).into(binding.ImageView)

                }
                is BaseResponse.Error->{
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                }
                is BaseResponse.Loading->{
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
    private fun editProfile() {
        binding.editProfile.setOnClickListener {
            startActivity(Intent(requireContext(),EditProfile::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModal()
    }


}