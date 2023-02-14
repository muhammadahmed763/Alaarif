package com.example.alaaripatient.profile.fragment.profilemvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alaaripatient.loginacitivity.mvvm.BaseResponse
import com.example.alaaripatient.profile.fragment.profileresponse.ProfileResonse
import com.example.alaaripatient.sharedprefobject.SessionManager
import kotlinx.coroutines.launch

class ProfileViewModal(val context: Context):ViewModel() {
    private val respository: ProfileRepository by lazy {
        ProfileRepository()
    }

    init {
        viewModelScope.launch {
            respository.getData("${SessionManager.getToken(context)}")
        }
    }

    val liveData:LiveData<BaseResponse<ProfileResonse>>
    get() = respository.liveData

}