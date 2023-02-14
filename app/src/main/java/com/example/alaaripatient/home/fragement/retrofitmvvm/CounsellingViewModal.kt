package com.example.alaaripatient.home.fragement.retrofitmvvm


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alaaripatient.sharedprefobject.SessionManager
import kotlinx.coroutines.launch

class CounsellingViewModal(val context:Context) : ViewModel(){
   val repository: CousellingRepository by lazy {
      CousellingRepository()
   }

   init {
       viewModelScope.launch {
          repository.getData("${SessionManager.getToken(context)}")
       }
   }
   val liveData:LiveData<CousellingResponse>
   get() = repository.coounselling
}