package com.example.alaaripatient.signupas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.example.alaaripatient.R
import com.example.alaaripatient.databinding.ActivityUserSignUpBinding

import com.example.alaaripatient.bottombaractivity.BottomActivity
import com.example.alaaripatient.retrofit.instance.RetrofitObject
import com.example.alaaripatient.sharedprefobject.SessionManager

import com.example.alaaripatient.usersigndataclass.SignupResponse
import kotlinx.coroutines.launch


class UserSignUp : AppCompatActivity() {
    var fabVisible = false
    var city=""
    var language=""
    var counrty=""
    var gender=""
    lateinit var binding:ActivityUserSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        vaidation()
        selectCountrySpinner()
        goSginIN()
    }

    private fun goSginIN() {
        binding.goSignInActivity.setOnClickListener {
            startActivity(Intent(this,Long::class.java))
        }
    }

    private fun vaidation() {
        fabVisible = false
        binding.firstNameEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length==0){
                    binding.firstV.visibility=View.INVISIBLE
                }else if (p0!!.length>4){
                    binding.firstV.visibility=View.VISIBLE
                    binding.firstV.setImageResource(R.drawable.done)
                }else if (p0!!.length>15){
                    binding.firstV.visibility=View.VISIBLE
                    binding.firstV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length<5){
                    binding.firstV.visibility=View.VISIBLE
                    binding.firstV.setImageResource(R.drawable.wrong)
                }
            }

        })
        binding.lastNameEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length==0){
                    binding.lastV.visibility=View.INVISIBLE
                }else if (p0!!.length>4){
                    binding.lastV.visibility=View.VISIBLE
                    binding.lastV.setImageResource(R.drawable.done)
                }else if (p0!!.length>15){
                    binding.lastV.visibility=View.VISIBLE
                    binding.lastV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length<5){
                    binding.lastV.visibility=View.VISIBLE
                    binding.lastV.setImageResource(R.drawable.wrong)
                }
            }

        })
        binding.emailEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (Patterns.EMAIL_ADDRESS.matcher(p0).matches()){
                    binding.emailV.visibility=View.VISIBLE
                    binding.emailV.setImageResource(R.drawable.done)
                }else if (p0!!.length>9){
                    binding.emailV.visibility=View.VISIBLE
                    binding.emailV.setImageResource(R.drawable.done)
                }else if (p0!!.length>20){
                    binding.emailV.visibility=View.VISIBLE
                    binding.emailV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length<10){
                    binding.emailV.visibility=View.VISIBLE
                    binding.emailV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length==0){
                    binding.emailV.visibility=View.INVISIBLE
                }
            }

        })
        binding.mobileEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length==0){
                    binding.mobileV.visibility=View.INVISIBLE
                }else if (p0?.length==11){
                    binding.mobileV.visibility=View.VISIBLE
                    binding.mobileV.setImageResource(R.drawable.done)
                }else if (p0?.length!! >11){
                    binding.mobileV.visibility=View.VISIBLE
                    binding.mobileV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length<11){
                    binding.mobileV.visibility=View.VISIBLE
                    binding.mobileV.setImageResource(R.drawable.wrong)
                }
            }

        })
        binding.ageEd.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length==0){
                    binding.ageV.visibility=View.INVISIBLE
                }else if (p0!!.length>1 && p0.length<=3){
                    binding.ageV.visibility=View.VISIBLE
                    binding.ageV.setImageResource(R.drawable.done)
                }else if (p0!!.length>3){
                    binding.ageV.visibility=View.VISIBLE
                    binding.ageV.setImageResource(R.drawable.wrong)
                }else if (p0!!.length<2){
                    binding.ageV.visibility=View.VISIBLE
                    binding.ageV.setImageResource(R.drawable.wrong)
                }
            }

        })


        binding.passwordVisibility.setOnClickListener {
            if (!fabVisible) {
                binding.passwordVisibility.setImageResource(R.drawable.visibility_off)
                binding.passwordEd.transformationMethod = PasswordTransformationMethod.getInstance()
                fabVisible = true
            } else {
                binding.passwordVisibility.setImageResource(R.drawable.seeeye)
                binding.passwordEd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                fabVisible = false
            }
        }
    }
    private fun selectCountrySpinner() {
        val languagearray = resources.getStringArray(R.array.Languages)
        val countryarray = resources.getStringArray(R.array.Country)
        val genderarray = resources.getStringArray(R.array.Gender)
        val cityarray = resources.getStringArray(R.array.City)
        val adapter = ArrayAdapter(this,R.layout.spinner_list,languagearray)
        binding.languageSpinner.adapter = adapter
        binding.languageSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                language="${languagearray[position]}"
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        val adaptercountry = ArrayAdapter(this,R.layout.spinner_list,countryarray)
        binding.countrySpinner.adapter = adaptercountry
        binding.countrySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                counrty="${countryarray[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        val adaptergender = ArrayAdapter(this,R.layout.spinner_list,genderarray)
        binding.selectR.adapter = adaptergender
        binding.selectR.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                gender="${genderarray[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        val adaptercity = ArrayAdapter(this,R.layout.spinner_list,cityarray)
        binding.cityTownSpinner.adapter = adaptercity
        binding.cityTownSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                city="${cityarray[position]}"
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        binding.signInBtn.setOnClickListener {
            val firstName=binding.firstNameEd.text.toString()
            val lastName=binding.lastNameEd.text.toString()
            val email=binding.emailEd.text.toString()
            val mobile=binding.mobileEd.text.toString()
            val age=binding.ageEd.text.toString()

            val password=binding.passwordEd.text.toString()
            val street=binding.streetEd.text.toString()
            val area=binding.areaEd.text.toString()
            val usertype = intent.getStringExtra("user")
            lifecycleScope.launch{
                val modal=SignupResponse(age,"f","$area","$city","$counrty",
                    "+92","$email",
                    "$firstName","$gender",true,"$lastName","$mobile"
                    ,"$password","$language",
                    "$street","abc","abc","$usertype"
                )
                val call= RetrofitObject.api.userregister(modal)
                if (call.body()!=null){
                    SessionManager.saveAuthToken(this@UserSignUp,call!!.body()!!.data.data.token.accessToken)
                    if ( call.body()!!.isSuccess){
                        startActivity(Intent(this@UserSignUp,BottomActivity::class.java))
                    }
                }
            }
        }
    }
}