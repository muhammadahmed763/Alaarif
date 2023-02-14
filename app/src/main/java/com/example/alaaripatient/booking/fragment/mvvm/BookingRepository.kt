package com.example.alaaripatient.booking.fragment.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alaaripatient.booking.fragment.durationresponse.DurationResponse
import com.example.alaaripatient.retrofit.baseresponse.BaseResponse
import com.example.alaaripatient.retrofit.instance.RetrofitObject

class BookingRepository {
    private val data :MutableLiveData<BaseResponse<DurationResponse>> = MutableLiveData()

    val liveData:LiveData<BaseResponse<DurationResponse>>
    get() = data

    suspend fun getData(toke:String) {

            val response = RetrofitObject.api.getDuration("Bearer $toke")
            data.postValue(BaseResponse.Loading())
            if (response!=null){
                data.postValue(BaseResponse.Success(response.body()))
            }

    }
}