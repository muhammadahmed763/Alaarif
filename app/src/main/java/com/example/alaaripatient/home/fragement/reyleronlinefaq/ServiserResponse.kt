package com.example.alaaripatient.home.fragement.reyleronlinefaq

data class ServiserResponse(
    val `data`: List<ServiceData>,
    val isSuccess: Boolean,
    val message: String
)