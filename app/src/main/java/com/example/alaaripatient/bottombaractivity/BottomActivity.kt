package com.example.alaaripatient.bottombaractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.alaaripatient.R
import com.example.alaaripatient.callback.`interface`.CallBackActivity
import com.example.alaaripatient.databinding.ActivityBottomBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var callBackActivity: CallBackActivity
    val binding:ActivityBottomBinding by lazy {
        ActivityBottomBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navigationDrawer()
        bottomNavigation()

    }

    private fun bottomNavigation() {
        val navview:BottomNavigationView=binding.bottomBar
        val navController=findNavController(R.id.nav_host_fragment_activity_bottom_navigation)
        navview.setupWithNavController(navController)
    }

    private fun navigationDrawer() {
        binding.drawerBtn.setOnClickListener {
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
            binding.drawer.openDrawer(Gravity.LEFT)
        }
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        toggle= ActionBarDrawerToggle(this,binding.drawer,R.string.open,R.string.close)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

}