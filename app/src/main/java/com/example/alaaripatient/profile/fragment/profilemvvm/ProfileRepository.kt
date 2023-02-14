package com.example.alaaripatient.profile.fragment.profilemvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alaaripatient.loginacitivity.mvvm.BaseResponse
import com.example.alaaripatient.profile.fragment.profileresponse.ProfileResonse
import com.example.alaaripatient.retrofit.instance.RetrofitObject

class ProfileRepository {

    private val data:MutableLiveData<BaseResponse<ProfileResonse>> = MutableLiveData()

    val liveData:LiveData<BaseResponse<ProfileResonse>>
    get() = data

    suspend fun getData(token: String){
        try {
            data.value = BaseResponse.Loading()
            val response = RetrofitObject.api.getUserProfile("Bearer $token")
            if (response!=null){
                data.postValue(BaseResponse.Success(response.body()))
            }
        }catch (e:Exception){

        }

    }
}