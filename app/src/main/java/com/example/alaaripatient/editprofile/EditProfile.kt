package com.example.alaaripatient.editprofile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.alaaripatient.databinding.ActivityEditProfileBinding
import com.example.alaaripatient.retrofit.instance.RetrofitObject
import com.example.alaaripatient.profile.fragment.retrofituserprofile.UserProfileDataClass
import com.example.alaaripatient.sharedprefobject.SessionManager
import kotlinx.coroutines.launch

class EditProfile : AppCompatActivity() {
    private val pickImage = 100
    private var imageUri: Uri? = null
    lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editProfile()
    }

    private fun editProfile() {
        binding.editProfile.setOnClickListener { 
            openGallery()
        }
        binding.updateProfile.setOnClickListener {
            lifecycleScope.launch {
                val email=binding.emailEd.text.toString()
                val firstName=binding.firstNameEd.text.toString()
                val lastName=binding.lastNameEd.text.toString()
                val mobile=binding.mobileEd.text.toString()
                val modal= UserProfileDataClass("abc","${email}",
                    "${imageUri}","${firstName}",true,"${lastName}",
                    "abc","${mobile}","yes"
                )
                val response  = RetrofitObject.api.editUserProfile("Bearer ${SessionManager.getToken(this@EditProfile)}",modal)
                Toast.makeText(this@EditProfile, "${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, pickImage)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.ImageView.setImageURI(imageUri)
        }
    }
}