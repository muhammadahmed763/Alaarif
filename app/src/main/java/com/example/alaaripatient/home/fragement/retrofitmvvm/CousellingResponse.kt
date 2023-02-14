package com.example.alaaripatient.home.fragement.retrofitmvvm

data class CousellingResponse(
    val `data`: List<CounsellingModal>,
    val isSuccess: Boolean,
    val message: String
)