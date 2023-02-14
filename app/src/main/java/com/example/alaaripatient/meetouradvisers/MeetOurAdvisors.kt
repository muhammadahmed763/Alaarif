package com.example.alaaripatient.meetouradvisers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alaaripatient.R
import com.example.alaaripatient.meetouradvisers.recyler.AdvisorRecAdapter
import com.example.alaaripatient.meetouradvisers.recyler.AdvisorRecModal
import com.example.alaaripatient.databinding.ActivityMeetOurAdvisorsBinding

class MeetOurAdvisors : AppCompatActivity() {
    private lateinit var binding: ActivityMeetOurAdvisorsBinding
    val advisorRecAdapter: AdvisorRecAdapter by lazy {
        AdvisorRecAdapter(advisorRecModal)
    }
    private val advisorRecModal:ArrayList<AdvisorRecModal> by lazy {
        ArrayList()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMeetOurAdvisorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        advisorRecyler()
    }

    private fun advisorRecyler() {
        binding.advisorRecylerView.adapter=advisorRecAdapter
        advisorRecModal.add(
            AdvisorRecModal(
                R.drawable.ic_launcher_background,"Dr.M.Ahmed","30",
                "20K","30K")
        )
        advisorRecModal.add(
            AdvisorRecModal(
                R.drawable.ic_launcher_background,"Dr.M.Ahmed","30",
                "20K","30K")
        )
        advisorRecModal.add(
            AdvisorRecModal(
                R.drawable.ic_launcher_background,"Dr.M.Ahmed","30",
                "20K","30K")
        )

    }
}