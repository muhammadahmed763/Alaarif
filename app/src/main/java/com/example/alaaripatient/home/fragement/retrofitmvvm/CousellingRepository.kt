package com.example.alaaripatient.home.fragement.retrofitmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alaaripatient.retrofit.instance.RetrofitObject

class CousellingRepository {
    private val livedata:MutableLiveData<CousellingResponse> = MutableLiveData()

    val coounselling: LiveData<CousellingResponse>
    get() = livedata

    suspend fun getData(token: String){
        val response = RetrofitObject.api.getalltopices("Bearer $token")
        if (response.body()!=null){
            livedata.postValue(response.body())
        }
    }
}
