package com.example.alaaripatient.home.fragement


import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alaaripatient.R
import com.example.alaaripatient.callback.`interface`.CallBackAdapter
import com.example.alaaripatient.databinding.FragmentHomeBinding
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingFactory
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingModal
import com.example.alaaripatient.home.fragement.retrofitmvvm.CounsellingViewModal
import com.example.alaaripatient.home.fragement.retrofitmvvm.RecylerCounsellingAdapter
import com.example.alaaripatient.homerecylerclick.HomeRecClick
import com.example.alaaripatient.home.fragement.recylerwebinar.RecylerWebinarAdapter
import com.example.alaaripatient.home.fragement.recylerwebinar.RecylerWebinarModal
import com.example.alaaripatient.home.fragement.reyleronlinefaq.RecylerServicesAdapter
import com.example.alaaripatient.home.fragement.reyleronlinefaq.ServiceData
import com.example.alaaripatient.home.fragement.reyleronlinefaq.ServicesViewModal

class Home : Fragment() {
    lateinit var counsellingViewModal: CounsellingViewModal
    private lateinit var viewModel: ServicesViewModal
    lateinit var binding:FragmentHomeBinding
    val recylerWebinarAdapter: RecylerWebinarAdapter by lazy { RecylerWebinarAdapter(recylerWebinarModal) }
    private val recylerWebinarModal:ArrayList<RecylerWebinarModal> by lazy { ArrayList() }
    val recylerOnlineFaqAdapter: RecylerServicesAdapter by lazy { RecylerServicesAdapter(recylerOnlineFaqModal) }
    val recylerOnlineFaqModal:ArrayList<ServiceData> by lazy { ArrayList() }
    private val recylerCounsellingAdapter: RecylerCounsellingAdapter by lazy { RecylerCounsellingAdapter(cousellingModal) }
    private val cousellingModal:ArrayList<CounsellingModal> by lazy { ArrayList() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(inflater, container, false)

        counsellingViewModal=ViewModelProvider(requireActivity(),
            CounsellingFactory(requireContext())
        ).get(CounsellingViewModal::class.java)
        counsellingViewModal.liveData.observe(requireActivity(),Observer{
            cousellingModal.addAll(it.data)
            recylerCounsellingAdapter.notifyDataSetChanged()
        })
        Toast.makeText(requireContext(), "ok", Toast.LENGTH_LONG).show()
        viewModel = ViewModelProvider(requireActivity()).get(ServicesViewModal::class.java)
        viewModel.getdata()
        viewModel.data.observe(requireActivity(), Observer {
            recylerOnlineFaqModal.addAll(it.data)
            recylerOnlineFaqAdapter.notifyDataSetChanged()
        })

        recylerCouselling()
        recylerWebinar()
        recylerFaq()



        var view=binding.root
        return view
    }
    private fun recylerWebinar() {
        binding.recylerWebinar.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.recylerWebinar.adapter=recylerWebinarAdapter
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar1","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar2","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarModal.add(RecylerWebinarModal(R.drawable.ic_launcher_background,"Webinar3","Sep 30, 2021 - 8:00 PM"))
        recylerWebinarAdapter.callBack(object :CallBackAdapter{
            override fun callback(position: Int, modal: RecylerWebinarModal) {

            }
        })
    }
    private fun recylerFaq() {
        binding.reylerfaq.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.reylerfaq.adapter=recylerOnlineFaqAdapter
        recylerOnlineFaqAdapter.notifyDataSetChanged()

    }
    private fun recylerCouselling(){
        binding.recylerOnlineCounseling.adapter=recylerCounsellingAdapter
        recylerCounsellingAdapter.clickFun(object :RecylerCounsellingAdapter.HomeRecClick{
            override fun recClick(position: Int, modal: CounsellingModal) {
                var intent= Intent(requireContext(),HomeRecClick::class.java)
                intent.putExtra("Modal",modal)
                startActivity(intent)
//                var dialogue= LayoutInflater.from(requireContext()).inflate(R.layout.alerdialogue,null);
//                var start: TextView
//                val dialog = Dialog(requireContext())
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//                dialog.setCancelable(false)
//                start=dialogue.findViewById(R.id.startBtn)
//
//                var builder= AlertDialog.Builder(requireContext())
//                    .setView(dialogue)
//                var alertM=builder.show()
//                alertM.setCancelable(false)
//
//                start.setOnClickListener {
//                    alertM.dismiss()
//                }

                }


        })
        recylerOnlineFaqAdapter.notifyDataSetChanged()
    }

}