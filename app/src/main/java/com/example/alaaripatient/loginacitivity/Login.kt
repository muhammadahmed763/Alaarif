package com.example.alaaripatient.loginacitivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.alaaripatient.R
import com.example.alaaripatient.databinding.ActivityLoginBinding
import com.example.alaaripatient.bottombaractivity.BottomActivity
import com.example.alaaripatient.retrofit.instance.RetrofitObject
import com.example.alaaripatient.sharedprefobject.SessionManager
import com.example.alaaripatient.usersigndataclass.LoginResponse
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {
    var passwordIcone =false
    var check=false
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        passwordHide()
        loginButton()
    }

    private fun loginButton() {
        binding.goSignInActivity.setOnClickListener {
            startActivity(Intent(this,BottomActivity::class.java))
        }
        binding.signInBtn.setOnClickListener {
            val email=binding.emailEd.text.toString()
            val password=binding.passwordEd.text.toString()
            lifecycleScope.launch {
                val modal=LoginResponse(email,password)
                val call= RetrofitObject.api.login(modal)
                SessionManager.saveAuthToken(this@Login,call.body()!!.data.token.accessToken)
                if (call!!.body()!!.isSuccess){
                    startActivity(Intent(this@Login,BottomActivity::class.java))
                }else{

                }
            }
        }
        binding.emailEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                check=isChech()
                if (check){
                    binding.emailV.setImageResource(R.drawable.done)
                }else if (binding.emailEd.length()==0){
                    binding.emailV.setImageResource(R.drawable.seeeye)
                }else{
                    binding.emailV.setImageResource(R.drawable.wrong)
                }
            }

        })
    }
    fun isChech():Boolean{
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEd.text.toString()).matches()){
            return false
        }
        return true
    }

    private fun passwordHide() {
        passwordIcone=false
        binding.passwordVisibility.setOnClickListener {
            if (!passwordIcone){
                binding.passwordEd.transformationMethod = PasswordTransformationMethod.getInstance()
                Toast.makeText(this, "Hide", Toast.LENGTH_SHORT).show()
                binding.passwordVisibility.setImageResource(R.drawable.visibility_off)
                passwordIcone=true
            }else{
                binding.passwordEd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show()
                binding.passwordVisibility.setImageResource(R.drawable.seeeye)
                passwordIcone=false
            }
        }
    }
}