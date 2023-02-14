package com.example.alaaripatient.activity.allcustomerrecyler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alaaripatient.retrofit.instance.RetrofitObject

class AllCustomerRepository {

    private val data:MutableLiveData<CustomerResponse> = MutableLiveData()

    val liveData:LiveData<CustomerResponse>
    get() = data

    suspend fun getData(){
        try {

            val response = RetrofitObject.api.getAllCustomer()
            if (response.body()!=null){
                data.postValue(response.body())
            }
        }catch (e:Exception){
        }
    }


}