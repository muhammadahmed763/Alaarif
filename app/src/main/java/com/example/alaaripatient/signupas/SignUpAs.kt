package com.example.alaaripatient.signupas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.alaaripatient.R
import com.example.alaaripatient.databinding.ActivitySignUpAsBinding
import com.example.alaaripatient.loginacitivity.Login

class SignUpAs : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpAsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpAsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userSignUp()
        alreadyHaveAccount()
        doctorSignUp()
        companySignUp()
        layoutAnim()
    }

    private fun layoutAnim() {
        val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.rightsideanim)
        binding.animationL.startAnimation(animationSlideUp)
    }

    private fun alreadyHaveAccount() {
        binding.goSignInActivity.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
    }

    private fun companySignUp() {
    }

    private fun doctorSignUp() {
        binding.doctorSignUp.setOnClickListener {
            val intent = Intent(this@SignUpAs, DoctorSignUp::class.java)
            intent.putExtra("user","consultant")
            startActivity(intent)
        }
    }

    private fun userSignUp() {
        binding.userSignUp.setOnClickListener {
            val intent = Intent(this@SignUpAs, UserSignUp::class.java)
            intent.putExtra("user","customer")
            startActivity(intent)
        }
    }
}