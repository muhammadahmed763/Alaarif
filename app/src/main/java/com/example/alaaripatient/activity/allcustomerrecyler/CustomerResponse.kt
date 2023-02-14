package com.example.alaaripatient.activity.allcustomerrecyler

data class CustomerResponse(
    val `data`: List<CustomerData>,
    val isSuccess: Boolean,
    val message: String
)