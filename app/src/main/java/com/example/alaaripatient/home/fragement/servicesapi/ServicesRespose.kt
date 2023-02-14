package com.example.alaaripatient.home.fragement.servicesapi

data class ServicesRespose(
    val `data`: List<Data>,
    val isSuccess: Boolean,
    val message: String
)