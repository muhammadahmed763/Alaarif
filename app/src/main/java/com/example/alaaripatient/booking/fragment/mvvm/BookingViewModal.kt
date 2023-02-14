package com.example.alaaripatient.booking.fragment.mvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alaaripatient.booking.fragment.durationresponse.DurationResponse
import com.example.alaaripatient.retrofit.baseresponse.BaseResponse
import com.example.alaaripatient.sharedprefobject.SessionManager
import kotlinx.coroutines.launch

class BookingViewModal(val context: Context):ViewModel() {
    private val repository:BookingRepository by lazy {
        BookingRepository()
    }

    init {
        viewModelScope.launch {
            repository.getData("${SessionManager.getToken(context)}")
        }
    }

    val liveData:LiveData<BaseResponse<DurationResponse>>
        get() = repository.liveData
}