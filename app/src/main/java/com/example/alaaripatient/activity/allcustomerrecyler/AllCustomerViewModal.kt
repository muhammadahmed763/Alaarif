package com.example.alaaripatient.activity.allcustomerrecyler

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AllCustomerViewModal:ViewModel() {
    private val repository: AllCustomerRepository by lazy {
        AllCustomerRepository()
    }

    init {
        viewModelScope.launch {
            repository.getData()
        }
    }

    val liveData:LiveData<CustomerResponse>
    get() = repository.liveData

}