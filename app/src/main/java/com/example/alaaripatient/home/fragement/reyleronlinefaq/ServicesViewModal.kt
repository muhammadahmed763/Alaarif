package com.example.alaaripatient.home.fragement.reyleronlinefaq

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alaaripatient.retrofit.instance.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServicesViewModal:ViewModel() {
    val modal:ArrayList<ServiceData> by lazy {
       ArrayList()
    }
    val data: MutableLiveData<ServiserResponse> = MutableLiveData()
    fun getdata(){
           val response:Call<ServiserResponse> = RetrofitObject.api.services("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiIxNjc1NjcwODM2NTA5IiwiaWF0IjoxNjc1NjcwODYzfQ.e_Q_qXfDvB1fO7QDWU8XlXnz1YStw_HcIaqKYGIZkgM")
        response.enqueue(object :Callback<ServiserResponse>{
            override fun onResponse(
                call: Call<ServiserResponse>,
                response: Response<ServiserResponse>
            ) {
                if (response.body()!=null){
                    modal.addAll(response.body()!!.data)
                    data.value=response.body()
                }
            }

            override fun onFailure(call: Call<ServiserResponse>, t: Throwable) {

            }

        })

//
//            recylerOnlineFaqAdapter.notifyDataSetChanged()

    }
}