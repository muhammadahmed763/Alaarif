package com.example.alaaripatient

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.alaaripatient.databinding.ActivityMainBinding
import com.example.alaaripatient.signupas.SignUpAs

class MainActivity : AppCompatActivity() {
    var isStarted = false
    var progressStatus = 0
    var handler: Handler? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animation()
        progressBar()
        splachScreen()
    }



    private fun progressBar() {
        handler = Handler(Handler.Callback {
            if (isStarted) {
                progressStatus++
            }
            binding.progressBarHorizontal.progress = progressStatus
            handler?.sendEmptyMessageDelayed(0, 3)
            true
        })
        handler?.sendEmptyMessage(0)
        isStarted = !isStarted
    }

    private fun animation() {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.animation)
            binding.slideUp.startAnimation(animationSlideUp)
    }
    private fun splachScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,SignUpAs::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 3000 is the delayed time in milliseconds.
    }
}